package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysConfig;

/**
 * SysConfigMapper class
 * 
 * @author DJ
 */
public interface SysConfigMapper
{
    /**
     * selectConfig method
     * 
     * @param config 
     * @return 
     */
    public SysConfig selectConfig(SysConfig config);

    /**
     *SysConfigMapper method
     * 
     * @param configId 
     * @return 
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * selectConfigList method
     * 
     * @param config 
     * @return 
     */
    public List<SysConfig> selectConfigList(SysConfig config);

    /**
     * selectConfigList method
     * 
     * @param configKey 
     * @return 
     */
    public SysConfig checkConfigKeyUnique(String configKey);

    /**
     * insertConfig method
     * 
     * @param config 
     * @return 
     */
    public int insertConfig(SysConfig config);

    /**
     * updateConfig method
     * 
     * @param config 
     * @return 
     */
    public int updateConfig(SysConfig config);

    /**
     * deleteConfigById method
     * 
     * @param configId 
     * @return 
     */
    public int deleteConfigById(Long configId);

    /**
     * deleteConfigByIds method
     * 
     * @param configIds 
     * @return 
     */
    public int deleteConfigByIds(Long[] configIds);
}
