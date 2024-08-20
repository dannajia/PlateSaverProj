package com.ht.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ht.common.core.domain.entity.SysDept;

/**
 * SysDeptMapper class
 * 
 * @author DJ
 */
public interface SysDeptMapper
{
    /**
     * selectDeptList method
     * 
     * @param dept 
     * @return 
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * selectDeptListByRoleId method
     * 
     * @param roleId 
     * @param deptCheckStrictly 
     * @return 
     */
    public List<Long> selectDeptListByRoleId(@Param("roleId") Long roleId, @Param("deptCheckStrictly") boolean deptCheckStrictly);

    /**
     * selectDeptById method
     * 
     * @param deptId 
     * @return 
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * selectChildrenDeptById method
     * 
     * @param deptId 
     * @return 
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);

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
    public int hasChildByDeptId(Long deptId);

    /**
     * checkDeptExistUser method
     * 
     * @param deptId 
     * @return
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * checkDeptNameUnique method
     * 
     * @param deptName 
     * @param parentId 
     * @return 
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

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
     * updateDeptStatusNormal method
     * 
     * @param deptIds 
     */
    public void updateDeptStatusNormal(Long[] deptIds);

    /**
     * updateDeptChildren method
     * 
     * @param depts 
     * @return 
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

    /**
     * deleteDeptById method
     * 
     * @param deptId 
     * @return 
     */
    public int deleteDeptById(Long deptId);
}
