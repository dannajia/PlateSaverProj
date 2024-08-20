package com.ht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * startup service
 * 
 * @author ht
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class HtApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HtApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Service starts   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
