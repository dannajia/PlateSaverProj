package com.ht.common.exception.user;

import com.ht.common.exception.base.BaseException;

/**
 * UserException class
 * 
 * @author DJ
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
