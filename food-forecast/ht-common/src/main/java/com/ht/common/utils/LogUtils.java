package com.ht.common.utils;

/**
 * LogUtils
 * 
 * @author DJ
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
