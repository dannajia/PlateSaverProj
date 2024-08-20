package com.ht.common.core.domain.entity;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.core.domain.BaseEntity;

/**
 * SysRole
 * 
 * @author DJ
 */
public class SysRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** roleId */
    @Excel(name = "roleId", cellType = ColumnType.NUMERIC)
    private Long roleId;

    /** roleName */
    @Excel(name = "roleName")
    private String roleName;

    /** roleKey */
    @Excel(name = "roleKey")
    private String roleKey;

    /** roleSort */
    @Excel(name = "roleSort")
    private Integer roleSort;

    /** dataScope（1：all data；2：seld-defined；3：local dept；4：local dept and underneath；5：self data） */
    @Excel(name = "dataScope", readConverterExp = "1=all data,2=self-defined,3=local dept,4=local dept and underneath,5=self data")
    private String dataScope;

    /** menuCheckStrictly（ 0：parentChild unrelated 1：parentChild related） */
    private boolean menuCheckStrictly;

    /** deptCheckStrictly（0：parentChild unrelated 1：parentChild related ） */
    private boolean deptCheckStrictly;

    /** status（0-active 1-deactivation） */
    @Excel(name = "status", readConverterExp = "0=active,1=deactivation")
    private String status;

    /** deletionFlag（0 notDeleted 2 deleted） */
    private String delFlag;

    /** role existing flag, default is not existed */
    private boolean flag = false;

    /** menuIds */
    private Long[] menuIds;

    /** deptIds */
    private Long[] deptIds;

    /** permissions */
    private Set<String> permissions;

    public SysRole()
    {

    }

    public SysRole(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.roleId);
    }

    public static boolean isAdmin(Long roleId)
    {
        return roleId != null && 1L == roleId;
    }

    @NotBlank(message = "roleName can't be blank")
    @Size(min = 0, max = 30, message = "roleName can't exceed 30 chars")
    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    @NotBlank(message = "roleKey can't be blank")
    @Size(min = 0, max = 100, message = "roleKey can't exceed 100 chars")
    public String getRoleKey()
    {
        return roleKey;
    }

    public void setRoleKey(String roleKey)
    {
        this.roleKey = roleKey;
    }

    @NotNull(message = "roleSort can't be blank")
    public Integer getRoleSort()
    {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort)
    {
        this.roleSort = roleSort;
    }

    public String getDataScope()
    {
        return dataScope;
    }

    public void setDataScope(String dataScope)
    {
        this.dataScope = dataScope;
    }

    public boolean isMenuCheckStrictly()
    {
        return menuCheckStrictly;
    }

    public void setMenuCheckStrictly(boolean menuCheckStrictly)
    {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public boolean isDeptCheckStrictly()
    {
        return deptCheckStrictly;
    }

    public void setDeptCheckStrictly(boolean deptCheckStrictly)
    {
        this.deptCheckStrictly = deptCheckStrictly;
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

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public Long[] getMenuIds()
    {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds)
    {
        this.menuIds = menuIds;
    }

    public Long[] getDeptIds()
    {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds)
    {
        this.deptIds = deptIds;
    }

    public Set<String> getPermissions()
    {
        return permissions;
    }

    public void setPermissions(Set<String> permissions)
    {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("roleKey", getRoleKey())
            .append("roleSort", getRoleSort())
            .append("dataScope", getDataScope())
            .append("menuCheckStrictly", isMenuCheckStrictly())
            .append("deptCheckStrictly", isDeptCheckStrictly())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
