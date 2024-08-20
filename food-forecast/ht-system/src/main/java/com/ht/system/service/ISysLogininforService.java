package com.ht.system.service;

import java.util.List;
import com.ht.system.domain.SysLogininfor;

/**
 * ISysLogininforService interface
 * 
 * @author DJ
 */
public interface ISysLogininforService
{
    /**
     * insertLogininfor method
     * 
     * @param logininfor 
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * selectLogininforList method
     * 
     * @param logininfor
     * @return 
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * deleteLogininforByIds method
     * 
     * @param infoIds 
     * @return 
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * cleanLogininfor method
     */
    public void cleanLogininfor();
}
