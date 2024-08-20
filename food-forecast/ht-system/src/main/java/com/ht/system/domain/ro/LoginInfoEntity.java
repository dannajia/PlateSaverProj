package com.ht.system.domain.ro;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginInfoEntity {
    @NotBlank(message = "phone number can't be blank")
    private String phonenumber;
    @NotBlank(message = "code can't be blank")
    private String code;

}
