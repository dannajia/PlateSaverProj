package com.ht.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.annotation.Excel.Type;
import com.ht.common.annotation.Excels;
import com.ht.common.core.domain.BaseEntity;
import com.ht.common.xss.Xss;

/**
 * SysUser
 * 
 * @author DJ
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** userId */
    @Excel(name = "userId", cellType = ColumnType.NUMERIC, prompt = "userId")
    private Long userId;

    /** deptId */
    @Excel(name = "deptId", type = Type.IMPORT)
    private Long deptId;

    /** userName */
    @Excel(name = "usrName")
    private String userName;

    /** nickName */
    @Excel(name = "nickName")
    private String nickName;

    /** email */
    @Excel(name = "email")
    private String email;

    /** phonenumber */
    @Excel(name = "phonenumber")
    private String phonenumber;

    /** sex */
    @Excel(name = "sex", readConverterExp = "0=male,1=female,2=unknown")
    private String sex;

    /** avatar */
    private String avatar;

    /** password */
    private String password;

    /** status（0 active 1 inactive） */
    @Excel(name = "status", readConverterExp = "0=active,1=inactive")
    private String status;

    /** delFlag（0 exists 2 deleted） */
    private String delFlag;

    /** loginIp */
    @Excel(name = "loginIP", type = Type.EXPORT)
    private String loginIp;

    /** loginDate */
    @Excel(name = "loginDate", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /** Department Object */
    @Excels({
        @Excel(name = "deptName", targetAttr = "deptName", type = Type.EXPORT),
        @Excel(name = "leader", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /** roles */
    private List<SysRole> roles;

    /** roleIds */
    private Long[] roleIds;

    /** postIds */
    private Long[] postIds;

    /** roleID */
    private Long roleId;

    public SysUser()
    {

    }

    public SysUser(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    @Xss(message = "nickName can't include special chars")
    @Size(min = 0, max = 30, message = "nickName can't exceed 30 chars")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Xss(message = "userName can't exceed special chars")
    @NotBlank(message = "userName can't be blank")
    @Size(min = 0, max = 30, message = "userName can't exceed 30 chars")
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Email(message = "Email address format is incorrect")
    @Size(min = 0, max = 50, message = "email can't exceed 50 chars")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "phone number can't exceed 10 chars")
    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(Long[] postIds)
    {
        this.postIds = postIds;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .toString();
    }
}
