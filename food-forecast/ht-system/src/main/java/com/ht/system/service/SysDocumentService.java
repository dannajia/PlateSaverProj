package com.ht.system.service;

import com.ht.system.domain.SysDocumentEntity;

import java.util.List;

public interface SysDocumentService {

    public int insert(SysDocumentEntity documentEntity);

    public int update(SysDocumentEntity documentEntity);

    public int del(Long id);

    public SysDocumentEntity detail(Long id);

    public List<SysDocumentEntity> list(SysDocumentEntity documentEntity);

}
