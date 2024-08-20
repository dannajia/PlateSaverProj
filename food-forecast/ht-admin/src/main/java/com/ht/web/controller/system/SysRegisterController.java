package com.ht.web.controller.system;

import com.ht.common.constant.Constants;
import com.ht.common.core.domain.R;
import com.ht.framework.web.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.model.RegisterBody;
import com.ht.common.utils.StringUtils;
import com.ht.framework.web.service.SysRegisterService;
import com.ht.system.service.ISysConfigService;

/**
 * registraion controller
 *
 * @author DJ
 */
@RestController
public class SysRegisterController extends BaseController {
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private SysLoginService loginService;

    @PostMapping("/register")
    public R register(@RequestBody RegisterBody user) {
        /*if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("Registration function was not turned on in system！");
        }*/
        String msg = registerService.register(user);
        if (!StringUtils.isEmpty(msg)) {
            return R.fail(msg);
        }
        // registration succeeds，get user token
        // generate token
        String token = loginService.login(user.getUsername(), user.getPassword(), "", "");
        return R.ok(token);
    }
}
