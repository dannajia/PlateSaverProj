package com.ht.common.exception.user;

/**
 * CaptchaExpireException class
 * 
 * @author DJ
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}
