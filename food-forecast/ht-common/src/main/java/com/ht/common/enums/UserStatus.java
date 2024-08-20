package com.ht.common.enums;

/**
 * UserStatus
 * 
 * @author DJ
 */
public enum UserStatus
{
    OK("0", "active"), DISABLE("1", "inactive"), DELETED("2", "deleted");

    private final String code;
    private final String info;

    UserStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
