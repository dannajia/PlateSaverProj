package com.ht.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ht.system.domain.SysOperLog;
import com.ht.system.mapper.SysOperLogMapper;
import com.ht.system.service.ISysOperLogService;

/**
 * cSysOperLogServiceImpl class
 * 
 * @author DJ
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService
{
    @Autowired
    private SysOperLogMapper operLogMapper;

    /**
     * insertOperlog method
     * 
     * @param operLog 
     */
    @Override
    public void insertOperlog(SysOperLog operLog)
    {
        operLogMapper.insertOperlog(operLog);
    }

    /**
     * selectOperLogList method
     * 
     * @param operLog 
     * @return 
     */
    @Override
    public List<SysOperLog> selectOperLogList(SysOperLog operLog)
    {
        return operLogMapper.selectOperLogList(operLog);
    }

    /**
     * deleteOperLogByIds method
     * 
     * @param operIds 
     * @return 
     */
    @Override
    public int deleteOperLogByIds(Long[] operIds)
    {
        return operLogMapper.deleteOperLogByIds(operIds);
    }

    /**
     * selectOperLogById method
     * 
     * @param operId 
     * @return 
     */
    @Override
    public SysOperLog selectOperLogById(Long operId)
    {
        return operLogMapper.selectOperLogById(operId);
    }

    /**
     * cleanOperLog method
     */
    @Override
    public void cleanOperLog()
    {
        operLogMapper.cleanOperLog();
    }
}
