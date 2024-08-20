package com.ht.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ht.system.domain.SysUserInfo;
import com.ht.system.mapper.SysUserInfoMapper;
import com.ht.system.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper userInfoMapper;

    @Override
    public int insert(SysUserInfo sysUserInfo) {
        return userInfoMapper.insert(sysUserInfo);
    }

    @Override
    public int update(SysUserInfo sysUserInfo) {
        LambdaUpdateWrapper<SysUserInfo> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SysUserInfo::getUserId, sysUserInfo.getUserId());
        return userInfoMapper.update(sysUserInfo, wrapper);
    }

    @Override
    public SysUserInfo detail(Long id) {
        LambdaQueryWrapper<SysUserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserInfo::getUserId, id);
        return userInfoMapper.selectOne(wrapper);
    }
}
