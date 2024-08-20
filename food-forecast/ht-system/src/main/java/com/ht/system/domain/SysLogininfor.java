package com.ht.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.core.domain.BaseEntity;

/**
 * SysLogininfor class
 * 
 * @author DJ
 */
public class SysLogininfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "infoId", cellType = ColumnType.NUMERIC)
    private Long infoId;

    /** userName */
    @Excel(name = "userName")
    private String userName;

    /** status 0 succeed 1 fail */
    @Excel(name = "status", readConverterExp = "0=suceed,1=fail")
    private String status;

    @Excel(name = "ipaddr")
    private String ipaddr;

    @Excel(name = "loginLocation")
    private String loginLocation;

    @Excel(name = "browser")
    private String browser;

    @Excel(name = "os")
    private String os;

    @Excel(name = "msg")
    private String msg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "loginTime", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    public Long getInfoId()
    {
        return infoId;
    }

    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIpaddr()
    {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr)
    {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation()
    {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation)
    {
        this.loginLocation = loginLocation;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }
}
