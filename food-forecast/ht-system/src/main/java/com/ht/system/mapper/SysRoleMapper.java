package com.ht.system.mapper;

import java.util.List;
import com.ht.common.core.domain.entity.SysRole;

/**
 * SysRoleMapper interface
 * 
 * @author DJ
 */
public interface SysRoleMapper
{
    /**
     * selectRoleList() method
     * 
     * @param role 
     * @return 
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * selectRolePermissionByUserId() method
     * 
     * @param userId 
     * @return 
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

    /**
     * selectRoleAll method
     * 
     * @return 
     */
    public List<SysRole> selectRoleAll();

    /**
     * selectRoleListByUserId() method
     * 
     * @param userId 
     * @return
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * selectRoleById() method
     * 
     * @param roleId 
     * @return 
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * selectRolesByUserName() method
     * 
     * @param userName 
     * @return 
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * checkRoleNameUnique() method
     * 
     * @param roleName 
     * @return 
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * checkRoleKeyUnique() method
     * 
     * @param roleKey 
     * @return 
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * updateRole() method
     * 
     * @param role 
     * @return 
     */
    public int updateRole(SysRole role);

    /**
     * insertRole() method
     * 
     * @param role 
     * @return 
     */
    public int insertRole(SysRole role);

    /**
     * deleteRoleById method
     * 
     * @param roleId 
     * @return 
     */
    public int deleteRoleById(Long roleId);

    /**
     * deleteRoleByIds() method
     * 
     * @param roleIds 
     * @return 
     */
    public int deleteRoleByIds(Long[] roleIds);
}
