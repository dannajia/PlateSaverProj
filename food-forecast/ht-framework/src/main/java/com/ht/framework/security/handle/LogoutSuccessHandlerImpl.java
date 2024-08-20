package com.ht.framework.security.handle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import com.alibaba.fastjson2.JSON;
import com.ht.common.constant.Constants;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.model.LoginUser;
import com.ht.common.utils.ServletUtils;
import com.ht.common.utils.StringUtils;
import com.ht.framework.manager.AsyncManager;
import com.ht.framework.manager.factory.AsyncFactory;
import com.ht.framework.web.service.TokenService;

/**
 * LogoutSuccessHandlerImpl class
 * 
 * @author DJ
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * onLogoutSuccess() method
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            String userName = loginUser.getUsername();
            
            tokenService.delLoginUser(loginUser.getToken());
            
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "logout succeed"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success("logout succeed")));
    }
}
