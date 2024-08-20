package com.ht.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Config
 * 
 * @author DJ
 */
@Component
@ConfigurationProperties(prefix = "ht")
public class HtConfig
{
    /** project name */
    private String name;

    /** version */
    private String version;

    /** copy right year */
    private String copyrightYear;

    /** demo enabled */
    private boolean demoEnabled;

    /** profile */
    private static String profile;

    /** address enabled or not */
    private static boolean addressEnabled;

    /** type of captcha */
    private static String captchaType;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        this.copyrightYear = copyrightYear;
    }

    public boolean isDemoEnabled()
    {
        return demoEnabled;
    }

    public void setDemoEnabled(boolean demoEnabled)
    {
        this.demoEnabled = demoEnabled;
    }

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        HongtuConfig.profile = profile;
    }

    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled)
    {
        HongtuConfig.addressEnabled = addressEnabled;
    }

    public static String getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(String captchaType) {
        HongtuConfig.captchaType = captchaType;
    }

    /**
     * get the import path
     */
    public static String getImportPath()
    {
        return getProfile() + "/import";
    }

    /**
     * get the avatar path
     */
    public static String getAvatarPath()
    {
        return getProfile() + "/avatar";
    }

    /**
     * get the download path
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * get the upload path
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}
