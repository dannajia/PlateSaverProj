package com.ht.framework.web.service;

import com.ht.system.domain.SysUserInfo;
import com.ht.system.service.SysUserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ht.common.constant.CacheConstants;
import com.ht.common.constant.Constants;
import com.ht.common.constant.UserConstants;
import com.ht.common.core.domain.entity.SysUser;
import com.ht.common.core.domain.model.RegisterBody;
import com.ht.common.core.redis.RedisCache;
import com.ht.common.exception.user.CaptchaException;
import com.ht.common.exception.user.CaptchaExpireException;
import com.ht.common.utils.MessageUtils;
import com.ht.common.utils.SecurityUtils;
import com.ht.common.utils.StringUtils;
import com.ht.framework.manager.AsyncManager;
import com.ht.framework.manager.factory.AsyncFactory;
import com.ht.system.service.ISysConfigService;
import com.ht.system.service.ISysUserService;

/**
 * SysRegisterService class
 *
 * @author DJ
 */
@Component
public class SysRegisterService {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysUserInfoService userInfoService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    /**
     * register() method
     */
    public String register(RegisterBody registerBody) {
        String msg = "", username = registerBody.getUsername(), password = registerBody.getPassword();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setNickName(registerBody.getFirstName() + " " + registerBody.getLastName());
        sysUser.setPhonenumber(registerBody.getPhone());
        
        /*boolean captchaEnabled = configService.selectCaptchaEnabled();
        if (captchaEnabled)
        {
            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }*/

        if (StringUtils.isEmpty(username)) {
            msg = "user name can't empty";
        } else if (StringUtils.isEmpty(password)) {
            msg = "password can't empty";
        } else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            msg = "The account must be between 2 and 20 characters long";
        } else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            msg = "The password must be between 5 and 20 characters long\n";
        } else if (!userService.checkUserNameUnique(sysUser)) {
            msg = "register '" + username + "' fail，The registered account already exists";
        } else {
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag) {
                msg = "fail to register";
            } else {
                // store user info
                SysUserInfo userInfo = new SysUserInfo();
                BeanUtils.copyProperties(registerBody, userInfo);
                userInfo.setUserId(sysUser.getUserId());
                userInfoService.insert(userInfo);
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * validateCaptcha() method
     *
     * @param username 
     * @param code     
     * @param uuid     
     * @return 
     */
    public void validateCaptcha(String username, String code, String uuid) {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
    }
}
