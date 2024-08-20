package com.ht.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MPConfiguration {
    @Bean
    @Primary
    public EasySqlInjector easySqlInjector() {
        return new EasySqlInjector();
    }
}
