package com.ht.system.mapper;

import java.util.List;
import com.ht.common.core.domain.entity.SysDictType;

/**
 * SysDictTypeMapper class
 * 
 * @author DJ
 */
public interface SysDictTypeMapper
{
    /**
     * selectDictTypeList() method
     * 
     * @param dictType 
     * @return 
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * selectDictTypeAll() method
     * 
     * @return 
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * selectDictTypeById() method
     * 
     * @param dictId 
     * @return 
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * selectDictTypeByType() method
     * 
     * @param dictType 
     * @return 
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * deleteDictTypeById() method
     * 
     * @param dictId 
     * @return 
     */
    public int deleteDictTypeById(Long dictId);

    /**
     * deleteDictTypeByIds() method
     * 
     * @param dictIds 
     * @return 
     */
    public int deleteDictTypeByIds(Long[] dictIds);

    /**
     * insertDictType() method
     * 
     * @param dictType 
     * @return 
     */
    public int insertDictType(SysDictType dictType);

    /**
     * updateDictType() method
     * 
     * @param dictType
     * @return 
     */
    public int updateDictType(SysDictType dictType);

    /**
     * checkDictTypeUnique() method
     * 
     * @param dictType
     * @return 
     */
    public SysDictType checkDictTypeUnique(String dictType);
}
