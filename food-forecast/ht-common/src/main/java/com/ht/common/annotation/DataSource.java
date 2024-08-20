package com.ht.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ht.common.enums.DataSourceType;

/**
 * DataSource interface
 *
 * priority：method，then class
 *
 * @author DJ
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource
{
    /**
     * datasource value
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
