package com.ht.common.constant;

import io.jsonwebtoken.Claims;

/**
 * Constants
 * 
 * @author DJ
 */
public class Constants
{
    /**
     * UTF-8 character set
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK character set
     */
    public static final String GBK = "GBK";

    /**
     * www domain
     */
    public static final String WWW = "www.";

    /**
     * http request
     */
    public static final String HTTP = "http://";

    /**
     * https request
     */
    public static final String HTTPS = "https://";

    /**
     * Success
     */
    public static final String SUCCESS = "0";

    /**
     * Fail
     */
    public static final String FAIL = "1";

    /**
     * Login Success
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * Logout
     */
    public static final String LOGOUT = "Logout";

    /**
     * Register
     */
    public static final String REGISTER = "Register";

    /**
     * Login Failure
     */
    public static final String LOGIN_FAIL = "Error";
 
    /**
     * Captcha expiration time（min）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * token
     */
    public static final String TOKEN = "token";

    /**
     * token prefix
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * login user key
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * user ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * user name
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * avatar
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * creation time
     */
    public static final String JWT_CREATED = "created";

    /**
     * user authorities
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * resource prefix
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * whitelist string
     */
    public static final String[] JOB_WHITELIST_STR = { "com.ht" };

    /**
     * Job Error String
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.ht.common.utils.file", "com.ht.common.config" };
}
