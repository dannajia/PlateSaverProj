package com.ht.system.service;

import java.util.List;
import java.util.Set;
import com.ht.common.core.domain.TreeSelect;
import com.ht.common.core.domain.entity.SysMenu;
import com.ht.system.domain.vo.RouterVo;

/**
 * ISysMenuService interface
 * 
 * @author DJ
 */
public interface ISysMenuService
{
    /**
     * selectMenuList method
     * 
     * @param userId 
     * @return 
     */
    public List<SysMenu> selectMenuList(Long userId);

    /**
     * selectMenuList method
     * 
     * @param menu 
     * @param userId 
     * @return 
     */
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * selectMenuPermsByUserId method
     * 
     * @param userId 
     * @return 
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * selectMenuPermsByRoleId method
     * 
     * @param roleId 
     * @return 
     */
    public Set<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * selectMenuPermsByRoleId method
     * 
     * @param userId 
     * @return 
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * selectMenuListByRoleId method
     * 
     * @param roleId 
     * @return 
     */
    public List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * buildMenus method
     * 
     * @param menus 
     * @return 
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * buildMenuTree method
     * 
     * @param menus 
     * @return 
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * buildMenuTreeSelect method
     * 
     * @param menus 
     * @return 
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * selectMenuById method
     * 
     * @param menuId 
     * @return 
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * hasChildByMenuId
     * 
     * @param menuId 
     * @return 
     */
    public boolean hasChildByMenuId(Long menuId);

    /**
     * checkMenuExistRole method
     * 
     * @param menuId
     * @return
     */
    public boolean checkMenuExistRole(Long menuId);

    /**
     * insertMenu method
     * 
     * @param menu
     * @return 
     */
    public int insertMenu(SysMenu menu);

    /**
     * update menu
     * 
     * @param menu 
     * @return
     */
    public int updateMenu(SysMenu menu);

    /**
     * delete menu by id
     * 
     * @param menuId
     * @return
     */
    public int deleteMenuById(Long menuId);

    /**
     * check if menu name is unique
     * 
     * @param menu 
     * @return
     */
    public boolean checkMenuNameUnique(SysMenu menu);
}
