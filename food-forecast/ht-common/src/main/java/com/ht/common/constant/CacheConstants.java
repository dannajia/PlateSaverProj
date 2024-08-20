package com.ht.common.constant;

/**
 * cache key constants
 * 
 * @author DJ
 */
public class CacheConstants
{
    /**
     * login redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * captcha redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * sys config cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * dictionary cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * repeat submit redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * rate limit redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * password error count redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /**
     * sms code
     */
    public static final String LOGIN_SMS_CODE = "login_sms_code";
}
