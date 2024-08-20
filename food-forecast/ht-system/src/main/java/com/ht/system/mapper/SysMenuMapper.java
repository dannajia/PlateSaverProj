package com.ht.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ht.common.core.domain.entity.SysMenu;

/**
 * SysMenuMapper interface
 *
 * @author DJ
 */
public interface SysMenuMapper
{
    /**
     * SysMenuMapper() method
     *
     * @param menu
     * @return 
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * selectMenuPerms() method
     *
     * @return 
     */
    public List<String> selectMenuPerms();

    /**
     * selectMenuListByUserId() method
     *
     * @param menu 
     * @return 
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    /**
     * selectMenuPermsByRoleId() method
     * 
     * @param roleId 
     * @return 
     */
    public List<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * selectMenuPermsByUserId() method
     *
     * @param userId
     * @return 
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * selectMenuTreeAll() method
     *
     * @return 
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * selectMenuTreeByUserId() method
     *
     * @param userId
     * @return 
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * selectMenuListByRoleId() method
     * 
     * @param roleId 
     * @param menuCheckStrictly
     * @return 
     */
    public List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);

    /**
     * selectMenuById() method
     *
     * @param menuId 
     * @return 
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * hasChildByMenuId() method
     *
     * @param menuId
     * @return
     */
    public int hasChildByMenuId(Long menuId);

    /**
     * insertMenu method
     *
     * @param menu 
     * @return 
     */
    public int insertMenu(SysMenu menu);

    /**
     * updateMenu() method
     *
     * @param menu 
     * @return
     */
    public int updateMenu(SysMenu menu);

    /**
     * deleteMenuById() method
     *
     * @param menuId
     * @return 
     */
    public int deleteMenuById(Long menuId);

    /**
     * checkMenuNameUnique() method
     *
     * @param menuName 
     * @param parentId 
     * @return 
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}
