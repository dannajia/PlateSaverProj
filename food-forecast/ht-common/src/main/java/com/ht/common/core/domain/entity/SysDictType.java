package com.ht.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.core.domain.BaseEntity;

/**
 * sys_dict_type
 * 
 * @author DJ
 */
public class SysDictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** dictId */
    @Excel(name = "dictId", cellType = ColumnType.NUMERIC)
    private Long dictId;

    /** dictName */
    @Excel(name = "dictName")
    private String dictName;

    /** dictType */
    @Excel(name = "dictType")
    private String dictType;

    /** status（0 normal 1 stop） */
    @Excel(name = "status", readConverterExp = "0=normal,1=stop")
    private String status;

    public Long getDictId()
    {
        return dictId;
    }

    public void setDictId(Long dictId)
    {
        this.dictId = dictId;
    }

    @NotBlank(message = "dictName can't be null")
    @Size(min = 0, max = 100, message = "dictName can't exceed 100 chars")
    public String getDictName()
    {
        return dictName;
    }

    public void setDictName(String dictName)
    {
        this.dictName = dictName;
    }

    @NotBlank(message = "dictType can't be null")
    @Size(min = 0, max = 100, message = "dictTYpe can't exceed 100 chars")
    @Pattern(regexp = "^[a-z][a-z0-9_]*$", message = "dictType must start with letter of lower case or number or underscore")
    public String getDictType()
    {
        return dictType;
    }

    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dictId", getDictId())
            .append("dictName", getDictName())
            .append("dictType", getDictType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
