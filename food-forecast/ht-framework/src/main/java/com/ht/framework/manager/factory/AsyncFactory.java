package com.ht.framework.manager.factory;

import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ht.common.constant.Constants;
import com.ht.common.utils.LogUtils;
import com.ht.common.utils.ServletUtils;
import com.ht.common.utils.StringUtils;
import com.ht.common.utils.ip.AddressUtils;
import com.ht.common.utils.ip.IpUtils;
import com.ht.common.utils.spring.SpringUtils;
import com.ht.system.domain.SysLogininfor;
import com.ht.system.domain.SysOperLog;
import com.ht.system.service.ISysLogininforService;
import com.ht.system.service.ISysOperLogService;
import eu.bitwalker.useragentutils.UserAgent;

/**
 *  AsyncFactory class
 * 
 * @author DJ
 */
public class AsyncFactory
{
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * recordLogininfor() method
     * 
     * @param username
     * @param status 
     * @param message 
     * @param args 
     * @return task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message,
            final Object... args)
    {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr();
        return new TimerTask()
        {
            @Override
            public void run()
            {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                
                sys_user_logger.info(s.toString(), args);
                
                String os = userAgent.getOperatingSystem().getName();
                
                String browser = userAgent.getBrowser().getName();
                
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setUserName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                
                if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER))
                {
                    logininfor.setStatus(Constants.SUCCESS);
                }
                else if (Constants.LOGIN_FAIL.equals(status))
                {
                    logininfor.setStatus(Constants.FAIL);
                }
                
                SpringUtils.getBean(ISysLogininforService.class).insertLogininfor(logininfor);
            }
        };
    }

    /**
     * recordOper() method
     * 
     * @param operLog 
     * @return task
     */
    public static TimerTask recordOper(final SysOperLog operLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
                
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).insertOperlog(operLog);
            }
        };
    }
}
