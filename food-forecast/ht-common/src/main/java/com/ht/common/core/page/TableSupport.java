package com.ht.common.core.page;

import com.ht.common.core.text.Convert;
import com.ht.common.utils.ServletUtils;

/**
 * TableSupport class
 * 
 * @author DJ
 */
public class TableSupport
{
    /**
     * PAGE_NUM
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * PAGE_SIZE
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * ORDER_BY_COLUMN
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * order by "desc" or "asc".
     */
    public static final String IS_ASC = "isAsc";

    
    public static final String REASONABLE = "reasonable";

    /**
     * getPageDomain
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(Convert.toInt(ServletUtils.getParameter(PAGE_NUM), 1));
        pageDomain.setPageSize(Convert.toInt(ServletUtils.getParameter(PAGE_SIZE), 10));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(IS_ASC));
        pageDomain.setReasonable(ServletUtils.getParameterToBool(REASONABLE));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
