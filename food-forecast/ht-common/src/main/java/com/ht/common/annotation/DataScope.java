package com.ht.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Data Scope interface
 * 
 * @author DJ
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * department alias
     */
    public String deptAlias() default "";

    /**
     * user alias
     */
    public String userAlias() default "";

    /**
     * permission String（permission with multi roles), default permission is obtained from @ss，multi permissions are separated with comma
     */
    public String permission() default "";
}
