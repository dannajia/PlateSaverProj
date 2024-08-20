package com.ht.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import com.ht.common.utils.spring.SpringUtils;

/**
 * MessageUtils class
 * 
 * @author DJ
 */
public class MessageUtils
{
    /**
     * message()
     *
     * @param code 
     * @param args 
     * @return 
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
