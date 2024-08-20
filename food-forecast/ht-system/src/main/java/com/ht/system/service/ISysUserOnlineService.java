package com.ht.system.service;

import com.ht.common.core.domain.model.LoginUser;
import com.ht.system.domain.SysUserOnline;

/**
 * ISysUserOnlineService interface
 * 
 * @author DJ
 */
public interface ISysUserOnlineService
{
    /**
     * selectOnlineByIpaddr method
     * 
     * @param ipaddr 
     * @param user 
     * @return 
     */
    public SysUserOnline selectOnlineByIpaddr(String ipaddr, LoginUser user);

    /**
     * selectOnlineByUserName method
     * 
     * @param userName 
     * @param user 
     * @return 
     */
    public SysUserOnline selectOnlineByUserName(String userName, LoginUser user);

    /**
     * selectOnlineByInfo method
     * 
     * @param ipaddr 
     * @param userName 
     * @param user 
     * @return 
     */
    public SysUserOnline selectOnlineByInfo(String ipaddr, String userName, LoginUser user);

    /**
     * loginUserToUserOnline method
     * 
     * @param user 
     * @return 
     */
    public SysUserOnline loginUserToUserOnline(LoginUser user);
}
