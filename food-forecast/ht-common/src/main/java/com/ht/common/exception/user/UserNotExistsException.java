package com.ht.common.exception.user;

/**
 * UserNotExistsException class
 * 
 * @author DJ
 */
public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}
