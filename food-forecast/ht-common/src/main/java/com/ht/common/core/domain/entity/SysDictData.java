package com.ht.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.constant.UserConstants;
import com.ht.common.core.domain.BaseEntity;

/**
 * sys_dict_data
 * 
 * @author DJ
 */
public class SysDictData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** dictCode */
    @Excel(name = "dictCode", cellType = ColumnType.NUMERIC)
    private Long dictCode;

    /** dictSort */
    @Excel(name = "dictSort", cellType = ColumnType.NUMERIC)
    private Long dictSort;

    /** dictLable */
    @Excel(name = "dictLabel")
    private String dictLabel;

    /** dictValue */
    @Excel(name = "dictValue")
    private String dictValue;

    /** dictType */
    @Excel(name = "dictType")
    private String dictType;

    /** cssClass */
    private String cssClass;

    /** listClass */
    private String listClass;

    /** isDefault */
    @Excel(name = "isDefault", readConverterExp = "Y or N")
    private String isDefault;

    /** status（0 normal 1 stop） */
    @Excel(name = "status", readConverterExp = "0 normal,1 stop")
    private String status;

    public Long getDictCode()
    {
        return dictCode;
    }

    public void setDictCode(Long dictCode)
    {
        this.dictCode = dictCode;
    }

    public Long getDictSort()
    {
        return dictSort;
    }

    public void setDictSort(Long dictSort)
    {
        this.dictSort = dictSort;
    }

    @NotBlank(message = "dictLable can't be null")
    @Size(min = 0, max = 100, message = "dictLable can't exceed 100 chars")
    public String getDictLabel()
    {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel)
    {
        this.dictLabel = dictLabel;
    }

    @NotBlank(message = "dictValue can't be null")
    @Size(min = 0, max = 100, message = "dictValue can't exceed 100 chars")
    public String getDictValue()
    {
        return dictValue;
    }

    public void setDictValue(String dictValue)
    {
        this.dictValue = dictValue;
    }

    @NotBlank(message = "dictType can't be null")
    @Size(min = 0, max = 100, message = "dictType can't exceed 100 chars")
    public String getDictType()
    {
        return dictType;
    }

    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    @Size(min = 0, max = 100, message = "cssClass can't exceed 100 chars")
    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    public String getListClass()
    {
        return listClass;
    }

    public void setListClass(String listClass)
    {
        this.listClass = listClass;
    }

    public boolean getDefault()
    {
        return UserConstants.YES.equals(this.isDefault);
    }

    public String getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
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
            .append("dictCode", getDictCode())
            .append("dictSort", getDictSort())
            .append("dictLabel", getDictLabel())
            .append("dictValue", getDictValue())
            .append("dictType", getDictType())
            .append("cssClass", getCssClass())
            .append("listClass", getListClass())
            .append("isDefault", getIsDefault())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
