package com.ht.common.exception.file;

import com.ht.common.exception.base.BaseException;

/**
 * FileException
 * 
 * @author DJ
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
