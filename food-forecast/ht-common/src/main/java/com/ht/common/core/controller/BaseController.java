package com.ht.common.core.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.common.constant.HttpStatus;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.model.LoginUser;
import com.ht.common.core.page.PageDomain;
import com.ht.common.core.page.TableDataInfo;
import com.ht.common.core.page.TableSupport;
import com.ht.common.utils.DateUtils;
import com.ht.common.utils.PageUtils;
import com.ht.common.utils.SecurityUtils;
import com.ht.common.utils.StringUtils;
import com.ht.common.utils.sql.SqlUtil;

/**
 * web base controller
 * 
 * @author DJ
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * the string of date passd from front-end is converted to Date type 
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date type convert
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * startPage
     */
    protected void startPage()
    {
        PageUtils.startPage();
    }

    /**
     * startOrderBy
     */
    protected void startOrderBy()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy()))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.orderBy(orderBy);
        }
    }

    /**
     * clearPage
     */
    protected void clearPage()
    {
        PageUtils.clearPage();
    }

    /**
     * getDataTable
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * success
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * error
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * success
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }
    
    /**
     * success
     */
    public AjaxResult success(Object data)
    {
        return AjaxResult.success(data);
    }

    /**
     * error
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * warn
     */
    public AjaxResult warn(String message)
    {
        return AjaxResult.warn(message);
    }

    /**
     * toAjax()
     * 
     * @param rows 
     * @return 
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * toAjax()
     * 
     * @param result 
     * @return 
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * redirect()
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }

    /**
     * getLoginUser()
     */
    public LoginUser getLoginUser()
    {
        return SecurityUtils.getLoginUser();
    }

    /**
     * getUserId()
     */
    public Long getUserId()
    {
        return getLoginUser().getUserId();
    }

    /**
     * getDeptId()
     */
    public Long getDeptId()
    {
        return getLoginUser().getDeptId();
    }

    /**
     * getUserName()
     */
    public String getUsername()
    {
        return getLoginUser().getUsername();
    }
}
