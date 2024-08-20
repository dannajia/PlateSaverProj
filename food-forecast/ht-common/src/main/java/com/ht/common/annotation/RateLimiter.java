package com.ht.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ht.common.constant.CacheConstants;
import com.ht.common.enums.LimitType;

/**
 * Rate Limiter
 * 
 * @author DJ
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter
{
    /**
     * Limits key
     */
    public String key() default CacheConstants.RATE_LIMIT_KEY;

    /**
     * the time of limits, sec is unit
     */
    public int time() default 60;

    /**
     * the count of limits
     */
    public int count() default 100;

    /**
     * Limit Type
     */
    public LimitType limitType() default LimitType.DEFAULT;
}
