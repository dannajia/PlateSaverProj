package com.ht.system.service;

import java.util.List;
import java.util.Set;
import com.ht.common.core.domain.entity.SysRole;
import com.ht.system.domain.SysUserRole;

/**
 * ISysRoleService interface
 * 
 * @author DJ
 */
public interface ISysRoleService
{
    /**
     * select RoleList method
     * 
     * @param role 
     * @return 
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * select RolesByUserId method
     * 
     * @param userId 
     * @return 
     */
    public List<SysRole> selectRolesByUserId(Long userId);

    /**
     * select RolePermissionByUserId method
     * 
     * @param userId 
     * @return 
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * select RoleAll method
     * 
     * @return 
     */
    public List<SysRole> selectRoleAll();

    /**
     * select RoleListByUserId method
     * 
     * @param userId 
     * @return 
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * select RoleById method
     * 
     * @param roleId 
     * @return 
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * checkRoleNameUnique method
     * 
     * @param role 
     * @return 
     */
    public boolean checkRoleNameUnique(SysRole role);

    /**
     * check RoleKeyUnique method
     * 
     * @param role 
     * @return 
     */
    public boolean checkRoleKeyUnique(SysRole role);

    /**
     * checkRoleAllowed method
     * 
     * @param role 
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * checkRoleDataScope method
     * 
     * @param roleId 
     */
    public void checkRoleDataScope(Long roleId);

    /**
     * countUserRoleByRoleId method
     * 
     * @param roleId 
     * @return 
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * insert Role method
     * 
     * @param role 
     * @return 
     */
    public int insertRole(SysRole role);

    /**
     * update Role method
     * 
     * @param role 
     * @return 
     */
    public int updateRole(SysRole role);

    /**
     * update RoleStatus method
     * 
     * @param role 
     * @return 
     */
    public int updateRoleStatus(SysRole role);

    /**
     * authDataScope method
     * 
     * @param role 
     * @return
     */
    public int authDataScope(SysRole role);

    /**
     * deleteRoleById() method
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

    /**
     * deleteAuthUser() method
     * 
     * @param userRole 
     * @return 
     */
    public int deleteAuthUser(SysUserRole userRole);

    /**
     * deleteAuthUsers() methos
     * 
     * @param roleId 
     * @param userIds 
     * @return 
     */
    public int deleteAuthUsers(Long roleId, Long[] userIds);

    /**
     * insertAuthUsers method
     * 
     * @param roleId 
     * @param userIds 
     * @return 
     */
    public int insertAuthUsers(Long roleId, Long[] userIds);
}
