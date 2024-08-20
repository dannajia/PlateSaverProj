package com.ht.common.exception;

/**
 * ServiceException class
 * 
 * @author DJ
 */
public final class ServiceException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * error code
     */
    private Integer code;

    /**
     * erroe message
     */
    private String message;

    /**
     * detailed message, internal debug info 
     *
     * and {@link CommonResult#getDetailMessage()} 
     */
    private String detailMessage;

    /**
     * constructor
     */
    public ServiceException()
    {
    }

    public ServiceException(String message)
    {
        this.message = message;
    }

    public ServiceException(String message, Integer code)
    {
        this.message = message;
        this.code = code;
    }

    public String getDetailMessage()
    {
        return detailMessage;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public Integer getCode()
    {
        return code;
    }

    public ServiceException setMessage(String message)
    {
        this.message = message;
        return this;
    }

    public ServiceException setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
        return this;
    }
}