package com.ht.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ht.system.domain.SysUserRole;

/**
 * SysUserRoleMapper interface
 * 
 * @author DJ
 */
public interface SysUserRoleMapper
{
    /**
     * deleteUserRoleByUserId() method
     * 
     * @param userId 
     * @return
     */
    public int deleteUserRoleByUserId(Long userId);

    /**
     * deleteUserRole method
     * 
     * @param ids 
     * @return 
     */
    public int deleteUserRole(Long[] ids);

    /**
     * countUserRoleByRoleId() method
     * 
     * @param roleId 
     * @return 
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * batchUserRole() method
     * 
     * @param userRoleList 
     * @return 
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    /**
     * deleteUserRoleInfo method
     * 
     * @param userRole 
     * @return 
     */
    public int deleteUserRoleInfo(SysUserRole userRole);

    /**
     * deleteUserRoleInfos method
     * 
     * @param roleId 
     * @param userIds 
     * @return 
     */
    public int deleteUserRoleInfos(@Param("roleId") Long roleId, @Param("userIds") Long[] userIds);
}
