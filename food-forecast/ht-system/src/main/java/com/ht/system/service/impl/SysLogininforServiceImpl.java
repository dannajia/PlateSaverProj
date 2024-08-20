package com.ht.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ht.system.domain.SysLogininfor;
import com.ht.system.mapper.SysLogininforMapper;
import com.ht.system.service.ISysLogininforService;

/**
 * SysLogininforServiceImpl class
 * 
 * @author DJ
 */
@Service
public class SysLogininforServiceImpl implements ISysLogininforService
{

    @Autowired
    private SysLogininforMapper logininforMapper;

    /**
     * insertLogininfor method
     * 
     * @param logininfor 
     */
    @Override
    public void insertLogininfor(SysLogininfor logininfor)
    {
        logininforMapper.insertLogininfor(logininfor);
    }

    /**
     * selectLogininforList method
     * 
     * @param logininfor 
     * @return 
     */
    @Override
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor)
    {
        return logininforMapper.selectLogininforList(logininfor);
    }

    /**
     * deleteLogininforByIds method
     * 
     * @param infoIds 
     * @return 
     */
    @Override
    public int deleteLogininforByIds(Long[] infoIds)
    {
        return logininforMapper.deleteLogininforByIds(infoIds);
    }

    /**
     * cleanLogininfor method
     */
    @Override
    public void cleanLogininfor()
    {
        logininforMapper.cleanLogininfor();
    }
}
