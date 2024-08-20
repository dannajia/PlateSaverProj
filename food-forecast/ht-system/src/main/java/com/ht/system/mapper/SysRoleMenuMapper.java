package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysRoleMenu;

/**
 * SysRoleMenuMapper interface
 * 
 * @author DJ
 */
public interface SysRoleMenuMapper
{
    /**
     * checkMenuExistRole method
     * 
     * @param menuId
     * @return 
     */
    public int checkMenuExistRole(Long menuId);

    /**
     * deleteRoleMenuByRoleId method
     * 
     * @param roleId
     * @return 
     */
    public int deleteRoleMenuByRoleId(Long roleId);

    /**
     * deleteRoleMenu method
     * 
     * @param ids
     * @return 
     */
    public int deleteRoleMenu(Long[] ids);

    /**
     * batchRoleMenu method
     * 
     * @param roleMenuList 
     * @return 
     */
    public int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}
