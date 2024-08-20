package com.ht.system.service;

import java.util.List;
import com.ht.common.core.domain.entity.SysDictData;

/**
 * ISysDictDataService interface
 * 
 * @author DJ
 */
public interface ISysDictDataService
{
    /**
     * selectDictDataList method
     * 
     * @param dictData 
     * @return 
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * selectDictLabel method
     * 
     * @param dictType 
     * @param dictValue 
     * @return 
     */
    public String selectDictLabel(String dictType, String dictValue);

    /**
     * selectDictDataById method
     * 
     * @param dictCode 
     * @return 
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * deleteDictDataByIds method
     * 
     * @param dictCodes 
     */
    public void deleteDictDataByIds(Long[] dictCodes);

    /**
     * insertDictData method
     * 
     * @param dictData 
     * @return 
     */
    public int insertDictData(SysDictData dictData);

    /**
     * updateDictData method
     * 
     * @param dictData 
     * @return 
     */
    public int updateDictData(SysDictData dictData);
}
