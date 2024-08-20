package com.ht.common.core.domain;

import java.util.HashMap;
import com.ht.common.constant.HttpStatus;
import com.ht.common.utils.StringUtils;

/**
 * AjaxResult
 * 
 * @author DJ
 */
public class AjaxResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /** status code */
    public static final String CODE_TAG = "code";

    /** msg */
    public static final String MSG_TAG = "msg";

    /** data */
    public static final String DATA_TAG = "data";

    /**
     * constructor
     */
    public AjaxResult()
    {
    }

    /**
     * constructor
     * 
     * @param code 
     * @param msg 
     */
    public AjaxResult(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * constructor
     * 
     * @param code
     * @param msg 
     * @param data 
     */
    public AjaxResult(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * success
     * 
     * @return 
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("success");
    }

    /**
     * success
     * 
     * @return 
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("success", data);
    }

    /**
     * success
     * 
     * @param msg 
     * @return 
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * success
     * 
     * @param msg 
     * @param data 
     * @return 
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * warn
     *
     * @param msg 
     * @return 
     */
    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }

    /**
     * warn
     *
     * @param msg 
     * @param data 
     * @return
     */
    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.WARN, msg, data);
    }

    /**
     * error
     * 
     * @return 
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("fail");
    }

    /**
     * error
     * 
     * @param msg 
     * @return 
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * error
     * 
     * @param msg 
     * @param data 
     * @return 
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * error
     * 
     * @param code 
     * @param msg 
     * @return 
     */
    public static AjaxResult error(int code, String msg)
    {
        return new AjaxResult(code, msg, null);
    }

    /**
     * put
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
