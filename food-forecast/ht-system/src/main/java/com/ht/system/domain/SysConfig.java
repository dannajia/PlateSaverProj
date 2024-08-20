package com.ht.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.core.domain.BaseEntity;

/**
 * SysConfig class
 * 
 * @author DJ
 */
public class SysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    
    @Excel(name = "configId", cellType = ColumnType.NUMERIC)
    private Long configId;

    
    @Excel(name = "configName")
    private String configName;

    
    @Excel(name = "configKey")
    private String configKey;

    @Excel(name = "configValue")
    private String configValue;

    @Excel(name = "configType", readConverterExp = "Y, N")
    private String configType;

    public Long getConfigId()
    {
        return configId;
    }

    public void setConfigId(Long configId)
    {
        this.configId = configId;
    }

    @NotBlank(message = "configName can't be blank")
    @Size(min = 0, max = 100, message = "configName can't exceed 100 chars")
    public String getConfigName()
    {
        return configName;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    @NotBlank(message = "configKey can't be blank")
    @Size(min = 0, max = 100, message = "configKey can't exceed 100 chars")
    public String getConfigKey()
    {
        return configKey;
    }

    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    @NotBlank(message = "configValue can't be blank")
    @Size(min = 0, max = 500, message = "configValue can't exceed 500 chars")
    public String getConfigValue()
    {
        return configValue;
    }

    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }

    public String getConfigType()
    {
        return configType;
    }

    public void setConfigType(String configType)
    {
        this.configType = configType;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("configId", getConfigId())
            .append("configName", getConfigName())
            .append("configKey", getConfigKey())
            .append("configValue", getConfigValue())
            .append("configType", getConfigType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
