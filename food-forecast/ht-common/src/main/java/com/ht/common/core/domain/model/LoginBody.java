package com.ht.common.core.domain.model;

/**
 * LoginBody
 * 
 * @author DJ
 */
public class LoginBody
{
    /**
     * usrname
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * code
     */
    private String code;

    /**
     * uuid
     */
    private String uuid;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
}
