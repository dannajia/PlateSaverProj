package com.ht.common.exception.user;

/**
 * CaptchaException class
 * 
 * @author DJ
 */
public class CaptchaException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaException()
    {
        super("user.jcaptcha.error", null);
    }
}
