package com.ht.web.controller.system;

import java.util.List;
import java.util.Set;

import com.ht.common.core.domain.R;
import com.ht.system.domain.ro.LoginInfoEntity;
import com.ht.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ht.common.constant.Constants;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.entity.SysMenu;
import com.ht.common.core.domain.entity.SysUser;
import com.ht.common.core.domain.model.LoginBody;
import com.ht.common.utils.SecurityUtils;
import com.ht.framework.web.service.SysLoginService;
import com.ht.framework.web.service.SysPermissionService;
import com.ht.system.service.ISysMenuService;

/**
 * Login Controller
 *
 * @author DJ
 */
@RestController
public class SysLoginController {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    /**
     * login
     *
     * @param loginBody 
     * @return 
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginBody loginBody) {
        // token generation
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        return R.ok(token);
    }
 
    /**
     * login if account exists, otherwise register the new account
     *
     * @param loginInfo
     * @return
     */
    @PostMapping("/phoneLogin")
    public AjaxResult phoneLogin(@RequestBody @Validated LoginInfoEntity loginInfo) {
        // check phone number exists，otherwise register
        SysUser user = new SysUser();
        user.setPhonenumber(loginInfo.getPhonenumber());
        AjaxResult ajaxResult = AjaxResult.success();
        if (!userService.checkPhoneUnique(user)) {
            // login
            String token = loginService.login(loginInfo.getPhonenumber(), loginInfo.getCode());
            ajaxResult.put("token", token);
        } else {
            // register
            user.setUserName(loginInfo.getPhonenumber());
            user.setNickName(loginInfo.getPhonenumber());
            user.setPassword(SecurityUtils.encryptPassword("123456"));
            userService.insertUser(user);
            String token = loginService.getRegisterToken(loginInfo.getPhonenumber());
            ajaxResult.put("token", token);
        }
        return ajaxResult;
    }

    /**
     * getUserInfo
     *
     * @return userInfo
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // role set
        Set<String> roles = permissionService.getRolePermission(user);
        // permission set
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * get Routers
     *
     * @return router info
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }
}
