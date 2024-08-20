package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysRoleDept;

/**
 * SysRoleDeptMapper interface
 * 
 * @author DJ
 */
public interface SysRoleDeptMapper
{
    /**
     * deleteRoleDeptByRoleId() method
     * 
     * @param roleId 
     * @return 
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * deleteRoleDept() method
     * 
     * @param ids 
     * @return 
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * selectCountRoleDeptByDeptId method
     * 
     * @param deptId
     * @return
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * batchRoleDept method
     * 
     * @param roleDeptList 
     * @return 
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}
