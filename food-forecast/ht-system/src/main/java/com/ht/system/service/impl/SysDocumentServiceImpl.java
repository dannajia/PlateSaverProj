package com.ht.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ht.system.domain.SysDocumentEntity;
import com.ht.system.mapper.SysDocumentMapper;
import com.ht.system.service.SysDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDocumentServiceImpl implements SysDocumentService {

    @Autowired
    private SysDocumentMapper sysDocumentMapper;

    @Override
    public int insert(SysDocumentEntity documentEntity) {
        return sysDocumentMapper.insert(documentEntity);
    }

    @Override
    public int update(SysDocumentEntity documentEntity) {
        return sysDocumentMapper.updateById(documentEntity);
    }

    @Override
    public int del(Long id) {
        return sysDocumentMapper.deleteById(id);
    }

    @Override
    public SysDocumentEntity detail(Long id) {
        return sysDocumentMapper.selectById(id);
    }

    @Override
    public List<SysDocumentEntity> list(SysDocumentEntity documentEntity) {
        LambdaQueryWrapper<SysDocumentEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(documentEntity.getType() != null, SysDocumentEntity::getType, documentEntity.getType());
        return sysDocumentMapper.selectList(wrapper);
    }
}
