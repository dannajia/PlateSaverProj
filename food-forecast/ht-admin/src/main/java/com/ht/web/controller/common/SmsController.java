package com.ht.web.controller.common;

import com.aliyuncs.exceptions.ClientException;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.redis.RedisCache;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Sms controller
 */
@RestController
public class SmsController {

    @Autowired
    private RedisCache redisCache;

    @GetMapping("/getSmsCode")
    public AjaxResult getSmsCode(String phone) throws ClientException {
        
        String regex = "^(\\+?\\d{1,4})?[-.\\s]?((\\(\\d{1,3}\\))|\\d{1,3})[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
        if (!phone.matches(regex)) {
            return AjaxResult.error("incorrect cell phone number format");
        }
        
        String smsCode = redisCache.getCacheObject(phone);
        if (smsCode != null) {
            return AjaxResult.error("the request is too frequent, please try again later");
        }
        // generate random code
        String code = RandomStringUtils.randomNumeric(6);
        
        
        redisCache.setCacheObject(phone, code, 1, TimeUnit.MINUTES);
        redisCache.setCacheObject("check" + phone, code, 5, TimeUnit.MINUTES);
        System.out.println("code: " + code);
        return AjaxResult.success("verification code was sent successfully");
    }

}
