package com.ht.common.utils.sql;

import com.ht.common.exception.UtilException;
import com.ht.common.utils.StringUtils;

/**
 * SqlUtil class
 * 
 * @author J
 */
public class SqlUtil
{
    
    public static String SQL_REGEX = "and |extractvalue|updatexml|exec |insert |select |delete |update |drop |count |chr |mid |master |truncate |char |declare |or |+|user()";

  
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    
    public static String escapeOrderBySql(String value)
    {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value))
        {
            throw new UtilException("the value is not correct and can't look up");
        }
        return value;
    }

    /**
     * isValidOrderBySql method
     */
    public static boolean isValidOrderBySql(String value)
    {
        return value.matches(SQL_PATTERN);
    }

    /**
     * filterKeyword method
     */
    public static void filterKeyword(String value)
    {
        if (StringUtils.isEmpty(value))
        {
            return;
        }
        String[] sqlKeywords = StringUtils.split(SQL_REGEX, "\\|");
        for (String sqlKeyword : sqlKeywords)
        {
            if (StringUtils.indexOfIgnoreCase(value, sqlKeyword) > -1)
            {
                throw new UtilException("the index is out of order");
            }
        }
    }
}
