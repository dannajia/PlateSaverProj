package com.ht.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ht.common.config.HongtuConfig;
import com.ht.common.utils.StringUtils;

/**
 * index page
 *
 * @author DJ
 */
@RestController
public class SysIndexController
{
    /** system config */
    @Autowired
    private HongtuConfig htConfig;

    /**
     * prompts on index page
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("welcome to use {}backend admin framework，current version：v{}，please visit via front end url.", htConfig.getName(), htConfig.getVersion());
    }
}
