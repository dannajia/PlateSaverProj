package com.ht.system.service;

import java.util.List;
import com.ht.system.domain.SysOperLog;

/**
 * ISysOperLogService interface
 * 
 * @author DJ
 */
public interface ISysOperLogService
{
    /**
     * insert Operlog
     * 
     * @param operLog 
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * select OperLogList method
     * 
     * @param operLog 
     * @return 
     
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * delete OperLogByIds method
     * 
     * @param operIds 
     * @return 
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * select OperLogById method
     * 
     * @param operId
     * @return
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * clean OperLog method
     */
    public void cleanOperLog();
}
