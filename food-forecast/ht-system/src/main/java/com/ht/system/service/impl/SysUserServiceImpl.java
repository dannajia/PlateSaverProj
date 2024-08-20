package com.ht.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.ht.common.annotation.DataScope;
import com.ht.common.constant.UserConstants;
import com.ht.common.core.domain.entity.SysRole;
import com.ht.common.core.domain.entity.SysUser;
import com.ht.common.exception.ServiceException;
import com.ht.common.utils.SecurityUtils;
import com.ht.common.utils.StringUtils;
import com.ht.common.utils.bean.BeanValidators;
import com.ht.common.utils.spring.SpringUtils;
import com.ht.system.domain.SysPost;
import com.ht.system.domain.SysUserPost;
import com.ht.system.domain.SysUserRole;
import com.ht.system.mapper.SysPostMapper;
import com.ht.system.mapper.SysRoleMapper;
import com.ht.system.mapper.SysUserMapper;
import com.ht.system.mapper.SysUserPostMapper;
import com.ht.system.mapper.SysUserRoleMapper;
import com.ht.system.service.ISysConfigService;
import com.ht.system.service.ISysUserService;

/**
 * SysUserServiceImpl class
 *
 * @author DJ
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPostMapper postMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysUserPostMapper userPostMapper;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    protected Validator validator;

    /**
     * selectUserList method
     *
     * @param user 
     * @return 
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUserList(SysUser user) {
        return userMapper.selectUserList(user);
    }

    /**
     * selectAllocatedList method
     *
     * @param user 
     * @return 
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectAllocatedList(SysUser user) {
        return userMapper.selectAllocatedList(user);
    }

    /**
     * selectUnallocatedList method
     *
     * @param user 
     * @return 
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUnallocatedList(SysUser user) {
        return userMapper.selectUnallocatedList(user);
    }

    /**
     * selectUserByUserName method
     *
     * @param userName 
     * @return 
     */
    @Override
    public SysUser selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * selectUserById method
     *
     * @param userId 
     * @return 
     */
    @Override
    public SysUser selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * selectUserRoleGroup method
     *
     * @param userName 
     * @return 
     */
    @Override
    public String selectUserRoleGroup(String userName) {
        List<SysRole> list = roleMapper.selectRolesByUserName(userName);
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        return list.stream().map(SysRole::getRoleName).collect(Collectors.joining(","));
    }

    /**
     * selectUserPostGroup method
     *
     * @param userName 
     * @return 
     */
    @Override
    public String selectUserPostGroup(String userName) {
        List<SysPost> list = postMapper.selectPostsByUserName(userName);
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        return list.stream().map(SysPost::getPostName).collect(Collectors.joining(","));
    }

    /**
     * checkUserNameUnique method
     *
     * @param user
     * @return 
     */
    @Override
    public boolean checkUserNameUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkUserNameUnique(user.getUserName());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * checkPhoneUnique method
     *
     * @param user 
     * @return
     */
    @Override
    public boolean checkPhoneUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * checkEmailUnique method
     *
     * @param user 
     * @return
     */
    @Override
    public boolean checkEmailUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * checkUserAllowed method
     *
     * @param user 
     */
    @Override
    public void checkUserAllowed(SysUser user) {
        if (StringUtils.isNotNull(user.getUserId()) && user.isAdmin()) {
            throw new ServiceException("不允许操作超级管理员用户");
        }
    }

    /**
     * checkUserDataScope method
     *
     * @param userId 
     */
    @Override
    public void checkUserDataScope(Long userId) {
        if (!SysUser.isAdmin(SecurityUtils.getUserId())) {
            SysUser user = new SysUser();
            user.setUserId(userId);
            List<SysUser> users = SpringUtils.getAopProxy(this).selectUserList(user);
        }
    }

    /**
     * insertUser method
     *
     * @param user 
     * @return 
     */
    @Override
    @Transactional
    public int insertUser(SysUser user) {
        
        int rows = userMapper.insertUser(user);
        
        insertUserPost(user);
        
        insertUserRole(user);
        return rows;
    }

    /**
     * registerUser method
     *
     * @param user 
     * @return 
     */
    @Override
    public boolean registerUser(SysUser user) {
        return userMapper.insertUser(user) > 0;
    }

    /**
     * updateUser method
     *
     * @param user 
     * @return
     */
    @Override
    @Transactional
    public int updateUser(SysUser user) {
        Long userId = user.getUserId();
        
        userRoleMapper.deleteUserRoleByUserId(userId);
        
        insertUserRole(user);
        
        userPostMapper.deleteUserPostByUserId(userId);
        
        insertUserPost(user);
        return userMapper.updateUser(user);
    }

    /**
     * insertUserAuth method
     *
     * @param userId  
     * @param roleIds 
     */
    @Override
    @Transactional
    public void insertUserAuth(Long userId, Long[] roleIds) {
        userRoleMapper.deleteUserRoleByUserId(userId);
        insertUserRole(userId, roleIds);
    }
 
    /**
     * updateUserStatus method
     *
     * @param user 
     * @return 
     */
    @Override
    public int updateUserStatus(SysUser user) {
        return userMapper.updateUser(user);
    }

    /** 
     * updateUserProfile method
     *
     * @param user 
     * @return 
     */
    @Override
    public int updateUserProfile(SysUser user) {
        return userMapper.updateUser(user);
    }

    /**
     * updateUserAvatar method
     *
     * @param userName 
     * @param avatar   
     * @return 
     */
    @Override
    public boolean updateUserAvatar(String userName, String avatar) {
        return userMapper.updateUserAvatar(userName, avatar) > 0;
    }

    /**
     * resetPwd method
     *
     * @param user 
     * @return 
     */
    @Override
    public int resetPwd(SysUser user) {
        return userMapper.updateUser(user);
    }

    /**
     * resetUserPwd method
     *
     * @param userName 
     * @param password 
     * @return 
     */
    @Override
    public int resetUserPwd(String userName, String password) {
        return userMapper.resetUserPwd(userName, password);
    }

    /**
     * insertUserRole method
     *
     * @param user 
     */
    public void insertUserRole(SysUser user) {
        this.insertUserRole(user.getUserId(), user.getRoleIds());
    }

    /**
     * insertUserPost method
     *
     * @param user 
     */
    public void insertUserPost(SysUser user) {
        Long[] posts = user.getPostIds();
        if (StringUtils.isNotEmpty(posts)) {
            
            List<SysUserPost> list = new ArrayList<SysUserPost>(posts.length);
            for (Long postId : posts) {
                SysUserPost up = new SysUserPost();
                up.setUserId(user.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            userPostMapper.batchUserPost(list);
        }
    }

    /**
     * insertUserRole method
     *
     * @param userId  
     * @param roleIds 
     */
    public void insertUserRole(Long userId, Long[] roleIds) {
        if (StringUtils.isNotEmpty(roleIds)) {
            
            List<SysUserRole> list = new ArrayList<SysUserRole>(roleIds.length);
            for (Long roleId : roleIds) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                list.add(ur);
            }
            userRoleMapper.batchUserRole(list);
        }
    }

    /**
     * deleteUserById method
     *
     * @param userId 
     * @return 
     */
    @Override
    @Transactional
    public int deleteUserById(Long userId) {
        
        userRoleMapper.deleteUserRoleByUserId(userId);
        
        userPostMapper.deleteUserPostByUserId(userId);
        return userMapper.deleteUserById(userId);
    }

    /**
     * deleteUserByIds method
     *
     * @param userIds
     * @return 
     */
    @Override
    @Transactional
    public int deleteUserByIds(Long[] userIds) {
        for (Long userId : userIds) {
            checkUserAllowed(new SysUser(userId));
            checkUserDataScope(userId);
        }
        
        userRoleMapper.deleteUserRole(userIds);
        
        userPostMapper.deleteUserPost(userIds);
        return userMapper.deleteUserByIds(userIds);
    }

    /**
     * importUser method
     *
     * @param userList        
     * @param isUpdateSupport 
     * @param operName        
     * @return 
     */
    @Override
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0) {
            throw new ServiceException("the imported user can't be empty！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (SysUser user : userList) {
            try {
                
                SysUser u = userMapper.selectUserByUserName(user.getUserName());
                if (StringUtils.isNull(u)) {
                    BeanValidators.validateWithException(validator, user);
                    user.setPassword(SecurityUtils.encryptPassword(password));
                    user.setCreateBy(operName);
                    userMapper.insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、account " + user.getUserName() + " import is successful");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, user);
                    checkUserAllowed(u);
                    checkUserDataScope(u.getUserId());
                    user.setUserId(u.getUserId());
                    user.setUpdateBy(operName);
                    userMapper.updateUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、account " + user.getUserName() + " update is successful");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、account " + user.getUserName() + " already exists");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、account " + user.getUserName() + " import failed：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "Sorry, the import failed! the total of " + failureNum + " data formats are incorrect，the errors are as following：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "Congrats，data import is successful！the total of " + successNum + " imports，the data is as following：");
        }
        return successMsg.toString();
    }

    @Override
    public int realDeleteUserById(Long id) {
        return userMapper.realDeleteUserById(id);
    }
}
