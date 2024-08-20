package com.ht.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.common.core.domain.MpBaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@TableName(value = "sys_document")
public class SysDocumentEntity extends MpBaseEntity {
    private Long id;
    @NotBlank(message = "document name can't be blank")
    private String name;
    private Integer type;
    @NotBlank(message = "document content can't be blank")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
