package com.ht.framework.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import com.ht.common.utils.ServletUtils;

/**
 * ServerConfig class
 * 
 * @author DJ
 */
@Component
public class ServerConfig
{
    /**
     * getUrl()
     * 
     * @return 
     */
    public String getUrl()
    {
        HttpServletRequest request = ServletUtils.getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request)
    {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}
