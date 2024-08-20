package com.ht.common.core.domain.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * RegisterBody
 * 
 * @author DJ
 */
@Data
public class RegisterBody extends LoginBody
{
    @NotBlank(message = "The first name cannot be empty")
    private String firstName;
    @NotBlank(message = "The last name cannot be empty")
    private String lastName;
    @NotBlank(message = "The school cannot be empty")
    private String userSchool;
    @NotBlank(message = "The phone cannot be empty")
    private String phone;
}
