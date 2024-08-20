package com.ht.common.utils;

import com.github.pagehelper.PageHelper;
import com.ht.common.core.page.PageDomain;
import com.ht.common.core.page.TableSupport;
import com.ht.common.utils.sql.SqlUtil;

/**
 * PageUtils
 * 
 * @author DJ
 */
public class PageUtils extends PageHelper
{
    /**
     * startPage()
     */
    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * clearPage()
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
