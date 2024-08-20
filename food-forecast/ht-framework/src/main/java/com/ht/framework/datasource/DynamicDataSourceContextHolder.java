package com.ht.framework.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DynamicDataSourceContextHolder class
 * 
 * @author DJ
 */
public class DynamicDataSourceContextHolder
{
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * setDataSourceType() method
     */
    public static void setDataSourceType(String dsType)
    {
        log.info("set DataSourceType", dsType);
        CONTEXT_HOLDER.set(dsType);
    }

    /**
     * setDataSourceType() method
     */
    public static String getDataSourceType()
    {
        return CONTEXT_HOLDER.get();
    }

    /**
     * clearDataSourceType() method
     */
    public static void clearDataSourceType()
    {
        CONTEXT_HOLDER.remove();
    }
}
