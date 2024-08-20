package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysOperLog;

/**
 * SysOperLogMapper interface
 * 
 * @author DJ
 */
public interface SysOperLogMapper
{
    /**
     * insertOperlog() method
     * 
     * @param operLog 
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * selectOperLogList() method
     * 
     * @param operLog 
     * @return 
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * deleteOperLogByIds() method
     * 
     * @param operIds
     * @return 
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * selectOperLogById method
     * 
     * @param operId 
     * @return 
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * cleanOperLog method
     */
    public void cleanOperLog();
}
