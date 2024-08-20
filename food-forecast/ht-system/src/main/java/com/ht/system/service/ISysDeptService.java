package com.ht.system.service;

import java.util.List;
import com.ht.common.core.domain.TreeSelect;
import com.ht.common.core.domain.entity.SysDept;

/**
 * ISysDeptService interface
 * 
 * @author DJ
 */
public interface ISysDeptService
{
    /**
     * selectDeptList method
     * 
     * @param dept 
     * @return 
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * selectDeptTreeList method
     * 
     * @param dept 
     * @return 
     */
    public List<TreeSelect> selectDeptTreeList(SysDept dept);

    /**
     * buildDeptTree method
     * 
     * @param depts 
     * @return 
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * buildDeptTree method
     * 
     * @param depts 
     * @return 
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * selectDeptListByRoleId method
     * 
     * @param roleId 
     * @return 
     */
    public List<Long> selectDeptListByRoleId(Long roleId);

    /**
     * selectDeptById method
     * 
     * @param deptId 
     * @return 
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * selectNormalChildrenDeptById method
     * 
     * @param deptId 
     * @return 
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * hasChildByDeptId method
     * 
     * @param deptId 
     * @return 
     */
    public boolean hasChildByDeptId(Long deptId);

    /**
     * hasChildByDeptId method
     * 
     * @param deptId 
     * @return 
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * checkDeptNameUnique method
     * 
     * @param dept 
     * @return 
     */
    public boolean checkDeptNameUnique(SysDept dept);

    /**
     * checkDeptDataScope method
     * 
     * @param deptId 
     */
    public void checkDeptDataScope(Long deptId);

    /**
     * insertDept method
     * 
     * @param dept 
     * @return 
     */
    public int insertDept(SysDept dept);

    /**
     * updateDept method
     * 
     * @param dept 
     * @return
     */
    public int updateDept(SysDept dept);

    /**
     * deleteDeptById method
     * 
     * @param deptId 
     * @return 
     */
    public int deleteDeptById(Long deptId);
}
