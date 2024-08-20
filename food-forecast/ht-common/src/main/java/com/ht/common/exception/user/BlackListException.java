package com.ht.common.exception.user;

/**
 * BlackListException class
 * 
 * @author DJ
 */
public class BlackListException extends UserException
{
    private static final long serialVersionUID = 1L;

    public BlackListException()
    {
        super("login.blocked", null);
    }
}
