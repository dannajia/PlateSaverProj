package com.ht.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ht.common.core.domain.entity.SysDictData;

/**
 * SysDictDataMapper class
 * 
 * @author DJ
 */
public interface SysDictDataMapper
{
    /**
     * selectDictDataList method
     * 
     * @param dictData 
     * @return 
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * selectDictDataByType method
     * 
     * @param dictType 
     * @return 
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * selectDictLabel method
     * 
     * @param dictType 
     * @param dictValue 
     * @return 
     */
    public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * selectDictDataById method
     * 
     * @param dictCode 
     * @return 
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * countDictDataByType method
     * 
     * @param dictType 
     * @return 
     */
    public int countDictDataByType(String dictType);

    /**
     * deleteDictDataById method
     * 
     * @param dictCode 
     * @return 
     */
    public int deleteDictDataById(Long dictCode);

    /**
     * deleteDictDataByIds method
     * 
     * @param dictCodes 
     * @return 
     */
    public int deleteDictDataByIds(Long[] dictCodes);

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

    /**
     * updateDictDataType method
     * 
     * @param oldDictType 
     * @param newDictType 
     * @return 
     */
    public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);
}
