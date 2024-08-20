package com.ht.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ht.common.enums.BusinessType;
import com.ht.common.enums.OperatorType;

/**
 * Log interface
 * 
 * @author DJ
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /**
     * Title
     */
    public String title() default "";

    /**
     * Business Type
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * Operator Type
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * Save Request Data or not 
     */
    public boolean isSaveRequestData() default true;

    /**
     * Save Response Data or not 
     */
    public boolean isSaveResponseData() default true;

    /**
     * Exclude Parameters
     */
    public String[] excludeParamNames() default {};
}
