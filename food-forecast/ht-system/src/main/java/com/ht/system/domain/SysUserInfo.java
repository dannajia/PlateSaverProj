package com.ht.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sys_user_info")
public class SysUserInfo {

    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String userSchool;
    private String phone;
    private Date createTime;
}
