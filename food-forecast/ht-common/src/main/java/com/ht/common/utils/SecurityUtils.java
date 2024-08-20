package com.ht.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ht.common.constant.HttpStatus;
import com.ht.common.core.domain.model.LoginUser;
import com.ht.common.exception.ServiceException;

/**
 * SecurityUtils class
 * 
 * @author DJ
 */
public class SecurityUtils
{
    /**
     * getUserId()
     **/
    public static Long getUserId()
    {
        try
        {
            return getLoginUser().getUserId();
        }
        catch (Exception e)
        {
            throw new ServiceException("error in getUserId", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * getDeptId()
     **/
    public static Long getDeptId()
    {
        try
        {
            return getLoginUser().getDeptId();
        }
        catch (Exception e)
        {
            throw new ServiceException("error in getDeptId", HttpStatus.UNAUTHORIZED);
        }
    }
    
    /**
     * getUsername()
     **/
    public static String getUsername()
    {
        try
        {
            return getLoginUser().getUsername();
        }
        catch (Exception e)
        {
            throw new ServiceException("error in getUsername", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * getLoginUser()
     **/
    public static LoginUser getLoginUser()
    {
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new ServiceException("error in getLoginUser", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * getAuthentication()
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * encryptPassword()
     *
     * @param password
     * @return 
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * matchesPassword()
     *
     * @param rawPassword 
     * @param encodedPassword 
     * @return 
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * isAdmin()
     * 
     * @param userId 
     * @return 
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}
