package com.ht.web.controller.system;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ht.common.core.domain.R;
import com.ht.common.core.domain.model.LoginUser;
import com.ht.food_forecast.service.FoodForecastRecordService;
import com.ht.food_forecast.service.FoodRecordService;
import com.ht.framework.web.service.TokenService;
import com.ht.system.domain.ro.LoginInfoEntity;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ht.common.annotation.Log;
import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.entity.SysDept;
import com.ht.common.core.domain.entity.SysRole;
import com.ht.common.core.domain.entity.SysUser;
import com.ht.common.core.page.TableDataInfo;
import com.ht.common.enums.BusinessType;
import com.ht.common.utils.SecurityUtils;
import com.ht.common.utils.StringUtils;
import com.ht.common.utils.poi.ExcelUtil;
import com.ht.system.service.ISysDeptService;
import com.ht.system.service.ISysPostService;
import com.ht.system.service.ISysRoleService;
import com.ht.system.service.ISysUserService;

/**
 * User Controller
 *
 * @author DJ
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private FoodRecordService foodRecordService;
    @Autowired
    private FoodForecastRecordService foodForecastRecordService;

    @Autowired
    private TokenService tokenService;

    /**
     * get user list
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "userMgmt", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUser user) {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.exportExcel(response, list, "userData");
    }

    @Log(title = "userMgmt", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = userService.importUser(userList, updateSupport, operName);
        return success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.importTemplateExcel(response, "userData");
    }

    /**
     * get user info by user id
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = {"/", "/{userId}"})
    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) Long userId) {
        userService.checkUserDataScope(userId);
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        ajax.put("posts", postService.selectPostAll());
        if (StringUtils.isNotNull(userId)) {
            SysUser sysUser = userService.selectUserById(userId);
            ajax.put(AjaxResult.DATA_TAG, sysUser);
            ajax.put("postIds", postService.selectPostListByUserId(userId));
            ajax.put("roleIds", sysUser.getRoles().stream().map(SysRole::getRoleId).collect(Collectors.toList()));
        }
        return ajax;
    }

    /**
     * add user
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "userMgmt", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysUser user) {
        if (!userService.checkUserNameUnique(user)) {
            return error("newUser'" + user.getUserName() + "'failure，user name already exists");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
            return error("newUser'" + user.getUserName() + "'failure，phone number already exists");
        } else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
            return error("newUser'" + user.getUserName() + "'failure，email already exists");
        }
        user.setCreateBy(getUsername());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return toAjax(userService.insertUser(user));
    }

    /**
     * edit user
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "userMgmt", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        if (!userService.checkUserNameUnique(user)) {
            return error("editUser'" + user.getUserName() + "'failure，user name already exists");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user)) {
            return error("editUser'" + user.getUserName() + "'failure，phone number already exists");
        } else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user)) {
            return error("editUser'" + user.getUserName() + "'failure，email already exists");
        }
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUser(user));
    }

    /**
     * remove user by userId
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "userMgmt", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        if (ArrayUtils.contains(userIds, getUserId())) {
            return error("the current user can't be deleted");
        }
        return toAjax(userService.deleteUserByIds(userIds));
    }

    // remove user
    @DeleteMapping("/delUser")
    public AjaxResult removeUser() {
        Long[] users = new Long[]{SecurityUtils.getUserId()};
        return toAjax(userService.deleteUserByIds(users));
    }

    /**
     * reset password
     */
    @PreAuthorize("@ss.hasPermi('system:user:resetPwd')")
    @Log(title = "userMgmt", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(getUsername());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * change status
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "userMgmt", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUserStatus(user));
    }

    /**
     * get authorized user role info by userId
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/authRole/{userId}")
    public AjaxResult authRole(@PathVariable("userId") Long userId) {
        AjaxResult ajax = AjaxResult.success();
        SysUser user = userService.selectUserById(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        ajax.put("user", user);
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return ajax;
    }

    /**
     * insert authorized role
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "userMgmt", businessType = BusinessType.GRANT)
    @PutMapping("/authRole")
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds) {
        userService.checkUserDataScope(userId);
        userService.insertUserAuth(userId, roleIds);
        return success();
    }

    /**
     * get department tree list
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/deptTree")
    public AjaxResult deptTree(SysDept dept) {
        return success(deptService.selectDeptTreeList(dept));
    }

    /**
     * destroy user
     */
    @PostMapping("/destroyUser")
    public R destroyUser() {
        LoginUser loginUser = getLoginUser();
        // delete user
        foodRecordService.delByUserId(loginUser.getUserId());
        foodForecastRecordService.delByUserId(loginUser.getUserId());
        userService.realDeleteUserById(loginUser.getUserId());
        // exit
        String userToken = loginUser.getToken();
        // delete user token
        tokenService.delLoginUser(userToken);
        return R.ok();
    }
}
