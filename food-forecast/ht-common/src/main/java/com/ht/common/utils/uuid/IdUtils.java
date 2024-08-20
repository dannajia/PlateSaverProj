package com.ht.common.utils.uuid;

/**
 * IdUtils class
 * 
 * @author DJ
 */
public class IdUtils
{
    /**
     * randomUUID method
     * 
     * @return 
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * simpleUUID method
     * 
     * @return 
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * fastUUID method
     * 
     * @return 
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * fastSimpleUUID method
     * 
     * @return 
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }
}
