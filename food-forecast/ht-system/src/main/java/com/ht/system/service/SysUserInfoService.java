package com.ht.system.service;

import com.ht.system.domain.SysUserInfo;

public interface SysUserInfoService {

    public int insert(SysUserInfo sysUserInfo);

    public int update(SysUserInfo sysUserInfo);

    public SysUserInfo detail(Long id);

}
