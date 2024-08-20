package com.ht.framework.security.context;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import com.ht.common.core.text.Convert;

/**
 * PermissionContextHolder class
 * 
 * @author DJ
 */
public class PermissionContextHolder
{
    private static final String PERMISSION_CONTEXT_ATTRIBUTES = "PERMISSION_CONTEXT";

    public static void setContext(String permission)
    {
        RequestContextHolder.currentRequestAttributes().setAttribute(PERMISSION_CONTEXT_ATTRIBUTES, permission,
                RequestAttributes.SCOPE_REQUEST);
    }

    public static String getContext()
    {
        return Convert.toStr(RequestContextHolder.currentRequestAttributes().getAttribute(PERMISSION_CONTEXT_ATTRIBUTES,
                RequestAttributes.SCOPE_REQUEST));
    }
}
