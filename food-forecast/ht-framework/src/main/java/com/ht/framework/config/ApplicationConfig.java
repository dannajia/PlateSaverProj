package com.ht.framework.config;

import java.util.TimeZone;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ApplicationConfig class 
 *
 * @author DJ
 */
@Configuration

@EnableAspectJAutoProxy(exposeProxy = true)

@MapperScan("com.ht.**.mapper")
public class ApplicationConfig
{
    /**
     * jacksonObjectMapperCustomization() method
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization()
    {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}
