package com.ht.system.service;

import java.util.List;
import com.ht.common.core.domain.entity.SysDictData;
import com.ht.common.core.domain.entity.SysDictType;

/**
 * ISysDictTypeService interface
 * 
 * @author DJ
 */
public interface ISysDictTypeService
{
    /**
     * selectDictTypeList method
     * 
     * @param dictType 
     * @return 
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * selectDictTypeAll method
     * 
     * @return 
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * selectDictDataByType method
     * 
     * @param dictType 
     * @return 
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * selectDictTypeById method
     * 
     * @param dictId 
     * @return 
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * selectDictTypeByType method
     * 
     * @param dictType 
     * @return 
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * deleteDictTypeByIds method
     * 
     * @param dictIds 
     */
    public void deleteDictTypeByIds(Long[] dictIds);

    /**
     * loadingDictCache method 
     */
    public void loadingDictCache();

    /**
     * clearDictCache method
     */
    public void clearDictCache();

    /**
     * resetDictCache method
     */
    public void resetDictCache();

    /**
     * insertDictType method
     * 
     * @param dictType 
     * @return 
     */
    public int insertDictType(SysDictType dictType);

    /**
     * updateDictType method
     * 
     * @param dictType 
     * @return 
     */
    public int updateDictType(SysDictType dictType);

    /**
     * checkDictTypeUnique method
     * 
     * @param dictType 
     * @return 
     */
    public boolean checkDictTypeUnique(SysDictType dictType);
}
