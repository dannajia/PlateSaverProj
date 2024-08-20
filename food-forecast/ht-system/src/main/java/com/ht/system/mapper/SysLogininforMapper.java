package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysLogininfor;

/**
 * checkDictTypeUnique interface
 * 
 * @author DJ
 */
public interface SysLogininforMapper
{
    /**
     * insertLogininfor() method
     * 
     * @param logininfor 
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * selectLogininforList() method
     * 
     * @param logininfor 
     * @return 
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * deleteLogininforByIds() method
     * 
     * @param infoIds 
     * @return 
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * cleanLogininfor() method
     * 
     * @return 
     */
    public int cleanLogininfor();
}
