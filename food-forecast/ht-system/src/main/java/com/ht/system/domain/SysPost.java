package com.ht.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ht.common.annotation.Excel;
import com.ht.common.annotation.Excel.ColumnType;
import com.ht.common.core.domain.BaseEntity;

/**
 * SysPost class
 * 
 * @author DJ
 */
public class SysPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "postId", cellType = ColumnType.NUMERIC)
    private Long postId;

    @Excel(name = "postCode")
    private String postCode;

    @Excel(name = "postName")
    private String postName;

    @Excel(name = "postSort")
    private Integer postSort;

    @Excel(name = "status", readConverterExp = "0=Normal,1=Stop")
    private String status;

    private boolean flag = false;

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    @NotBlank(message = "postCode can't be blank")
    @Size(min = 0, max = 64, message = "postCode can't exceed 64 chars")
    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    @NotBlank(message = "postName can't be blank")
    @Size(min = 0, max = 50, message = "postName can't exceed 50 chars")
    public String getPostName()
    {
        return postName;
    }

    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    @NotNull(message = "postSort can't be null")
    public Integer getPostSort()
    {
        return postSort;
    }

    public void setPostSort(Integer postSort)
    {
        this.postSort = postSort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
