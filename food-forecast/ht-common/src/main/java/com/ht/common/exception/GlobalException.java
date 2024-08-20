package com.ht.common.exception;

/**
 * GlobalException class
 * 
 * @author DJ
 */
public class GlobalException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * error msg
     */
    private String message;

    /**
     * detailed msg with internal debug info
     *
     * and {@link CommonResult#getDetailMessage()} 
     */
    private String detailMessage;

    /**
     * constructor
     */
    public GlobalException()
    {
    }

    public GlobalException(String message)
    {
        this.message = message;
    }

    public String getDetailMessage()
    {
        return detailMessage;
    }

    public GlobalException setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
        return this;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public GlobalException setMessage(String message)
    {
        this.message = message;
        return this;
    }
}