package com.ht.common.exception.user;

/**
 * UserPasswordNotMatchException class
 * 
 * @author DJ
 */
public class UserPasswordNotMatchException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super("user.password.not.match", null);
    }
}
