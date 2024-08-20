package com.ht.framework.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ht.common.core.domain.entity.SysUser;
import com.ht.common.core.domain.model.LoginUser;
import com.ht.common.enums.UserStatus;
import com.ht.common.exception.ServiceException;
import com.ht.common.utils.StringUtils;
import com.ht.system.service.ISysUserService;

/**
 * UserDetailsServiceImpl class
 *
 * @author DJ
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private ISysUserService userService;
    
    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        SysUser user = userService.selectUserByUserName(username);
        if (StringUtils.isNull(user))
        {
            log.info("the user：{} doesn't exist.", username);
            throw new ServiceException("user：" + username + " not exist");
        }
        else if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
        {
            log.info("the user：{} was deleted.", username);
            throw new ServiceException("sorry, your account：" + username + " be delete");
        }
        else if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            log.info("the user：{} was stopped.", username);
            throw new ServiceException("sorry, your account：" + username + " be stop");
        }

        passwordService.validate(user);

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user)
    {
        return new LoginUser(user.getUserId(), user.getDeptId(), user, permissionService.getMenuPermission(user));
    }
}
