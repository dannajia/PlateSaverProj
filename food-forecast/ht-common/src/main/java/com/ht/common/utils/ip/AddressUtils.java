package com.ht.common.utils.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ht.common.config.HongtuConfig;
import com.ht.common.constant.Constants;
import com.ht.common.utils.StringUtils;
import com.ht.common.utils.http.HttpUtils;

/**
 * AddressUtils class
 * 
 * @author DJ
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    
    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";

    
    public static final String UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip)
    {
        
        if (IpUtils.internalIp(ip))
        {
            return "internal IP";
        }
        if (HongtuConfig.isAddressEnabled())
        {
            try
            {
                String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&json=true", Constants.GBK);
                if (StringUtils.isEmpty(rspStr))
                {
                    log.error("getRealAddressByIP error {}", ip);
                    return UNKNOWN;
                }
                JSONObject obj = JSON.parseObject(rspStr);
                String region = obj.getString("pro");
                String city = obj.getString("city");
                return String.format("%s %s", region, city);
            }
            catch (Exception e)
            {
                log.error("getRealAddressByIP error {}", ip);
            }
        }
        return UNKNOWN;
    }
}
