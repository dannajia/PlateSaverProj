package com.ht.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Repeat Submit
 * 
 * @author DJ
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit
{
    /**
     * interval time (ms)，submission less than interval is counted as repeatable submission
     */
    public int interval() default 5000;

    /**
     * prompt messsage
     */
    public String message() default "repeatable submission is not allowed，please try again";
}
