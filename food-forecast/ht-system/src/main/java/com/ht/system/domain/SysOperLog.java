package com.ht.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.core.domain.BaseEntity;

/**
 * SysOperLog class
 * 
 * @author DJ
 */
public class SysOperLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "operId", cellType = ColumnType.NUMERIC)
    private Long operId;

    @Excel(name = "title")
    private String title;

    @Excel(name = "businessType", readConverterExp = "0=Other,1=New,2=Update,3=Delete,4=Authorize,5=Export,6=Import,7=Exit,8=CodeGen,9=Cleanup")
    private Integer businessType;

    private Integer[] businessTypes;

    @Excel(name = "method")
    private String method;

    @Excel(name = "requestMethod")
    private String requestMethod;

    @Excel(name = "operatorType", readConverterExp = "0=Other,1=backend,2=mobileUser")
    private Integer operatorType;

    @Excel(name = "operName")
    private String operName;

    @Excel(name = "deptName")
    private String deptName;

    @Excel(name = "operUrl")
    private String operUrl;

    @Excel(name = "operIp")
    private String operIp;

    @Excel(name = "operLocation")
    private String operLocation;

    @Excel(name = "operParam")
    private String operParam;

    @Excel(name = "jsonResult")
    private String jsonResult;

    @Excel(name = "status", readConverterExp = "0=normal,1=abnormal")
    private Integer status;

    @Excel(name = "errorMsg")
    private String errorMsg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "operTime", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operTime;

    @Excel(name = "costTime", suffix = "ms")
    private Long costTime;

    public Long getOperId()
    {
        return operId;
    }

    public void setOperId(Long operId)
    {
        this.operId = operId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getBusinessType()
    {
        return businessType;
    }

    public void setBusinessType(Integer businessType)
    {
        this.businessType = businessType;
    }

    public Integer[] getBusinessTypes()
    {
        return businessTypes;
    }

    public void setBusinessTypes(Integer[] businessTypes)
    {
        this.businessTypes = businessTypes;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getRequestMethod()
    {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType()
    {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType)
    {
        this.operatorType = operatorType;
    }

    public String getOperName()
    {
        return operName;
    }

    public void setOperName(String operName)
    {
        this.operName = operName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getOperUrl()
    {
        return operUrl;
    }

    public void setOperUrl(String operUrl)
    {
        this.operUrl = operUrl;
    }

    public String getOperIp()
    {
        return operIp;
    }

    public void setOperIp(String operIp)
    {
        this.operIp = operIp;
    }

    public String getOperLocation()
    {
        return operLocation;
    }

    public void setOperLocation(String operLocation)
    {
        this.operLocation = operLocation;
    }

    public String getOperParam()
    {
        return operParam;
    }

    public void setOperParam(String operParam)
    {
        this.operParam = operParam;
    }

    public String getJsonResult()
    {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult)
    {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime()
    {
        return operTime;
    }

    public void setOperTime(Date operTime)
    {
        this.operTime = operTime;
    }

    public Long getCostTime()
    {
        return costTime;
    }

    public void setCostTime(Long costTime)
    {
        this.costTime = costTime;
    }
}
