package com.ht.system.service;

import java.util.List;
import com.ht.system.domain.SysConfig;

/**
 * ISysConfigService interface
 * 
 * @author DJ
 */
public interface ISysConfigService
{
    /**
     * selectConfigById() method
     * 
     * @param configId 
     * @return 
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * selectConfigByKey() method
     * 
     * @param configKey 
     * @return 
     */
    public String selectConfigByKey(String configKey);

    /**
     * selectConfigList() method
     * 
     * @return 
     */
    public boolean selectCaptchaEnabled();

    /**
     * selectConfigList() method
     * 
     * @param config 
     * @return 
     */
    public List<SysConfig> selectConfigList(SysConfig config);

    /**
     * insertConfig() method
     * 
     * @param config 
     * @return 
     */
    public int insertConfig(SysConfig config);

    /**
     * updateConfig() method
     * 
     * @param config 
     * @return 
     */
    public int updateConfig(SysConfig config);

    /**
     * deleteConfigByIds() method
     * 
     * @param configIds 
     */
    public void deleteConfigByIds(Long[] configIds);

    /**
     * loadingConfigCache() method
     */
    public void loadingConfigCache();

    /**
     * clearConfigCache() method
     */
    public void clearConfigCache();

    /**
     * resetConfigCache() method
     */
    public void resetConfigCache();

    /**
     * checkConfigKeyUnique() method
     * 
     * @param config 
     * @return 
     */
    public boolean checkConfigKeyUnique(SysConfig config);
}
