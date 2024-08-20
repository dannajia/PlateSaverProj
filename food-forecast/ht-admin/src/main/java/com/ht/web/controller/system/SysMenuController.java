package com.ht.web.controller.system;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ht.common.annotation.Log;
import com.ht.common.constant.UserConstants;
import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.AjaxResult;
import com.ht.common.core.domain.entity.SysMenu;
import com.ht.common.enums.BusinessType;
import com.ht.common.utils.StringUtils;
import com.ht.system.service.ISysMenuService;

/**
 * System menu
 * 
 * @author DJ
 */
@RestController
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    /**
     * get list
     */
    @PreAuthorize("@ss.hasPermi('system:menu:list')")
    @GetMapping("/list")
    public AjaxResult list(SysMenu menu)
    {
        List<SysMenu> menus = menuService.selectMenuList(menu, getUserId());
        return success(menus);
    }

    /**
     * getInfo based on menuId
     */
    @PreAuthorize("@ss.hasPermi('system:menu:query')")
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable Long menuId)
    {
        return success(menuService.selectMenuById(menuId));
    }

    /**
     * get the menu tree
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysMenu menu)
    {
        List<SysMenu> menus = menuService.selectMenuList(menu, getUserId());
        return success(menuService.buildMenuTreeSelect(menus));
    }

    /**
     * get the mennu tree based on roleId
     */
    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    public AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId)
    {
        List<SysMenu> menus = menuService.selectMenuList(getUserId());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", menuService.selectMenuListByRoleId(roleId));
        ajax.put("menus", menuService.buildMenuTreeSelect(menus));
        return ajax;
    }

    /**
     * add the menu
     */
    @PreAuthorize("@ss.hasPermi('system:menu:add')")
    @Log(title = "menuMgmt", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysMenu menu)
    {
        if (!menuService.checkMenuNameUnique(menu))
        {
            return error("newMenu'" + menu.getMenuName() + "'failure，the menu name already exists");
        }
        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath()))
        {
            return error("newMenu'" + menu.getMenuName() + "failure，the url has to start with http(s)://");
        }
        menu.setCreateBy(getUsername());
        return toAjax(menuService.insertMenu(menu));
    }

    /**
     * update menu
     */
    @PreAuthorize("@ss.hasPermi('system:menu:edit')")
    @Log(title = "menuMgmt", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysMenu menu)
    {
        if (!menuService.checkMenuNameUnique(menu))
        {
            return error("updateMenu'" + menu.getMenuName() + "'failure，the menu name already exists");
        }
        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath()))
        {
            return error("updateMenu'" + menu.getMenuName() + "'failure，the path has to start with http(s)://");
        }
        else if (menu.getMenuId().equals(menu.getParentId()))
        {
            return error("updateMenu'" + menu.getMenuName() + "'failure，the parent menu can't be itself");
        }
        menu.setUpdateBy(getUsername());
        return toAjax(menuService.updateMenu(menu));
    }

    /**
     * remove menue
     */
    @PreAuthorize("@ss.hasPermi('system:menu:remove')")
    @Log(title = "menuMgmt", businessType = BusinessType.DELETE)
    @DeleteMapping("/{menuId}")
    public AjaxResult remove(@PathVariable("menuId") Long menuId)
    {
        if (menuService.hasChildByMenuId(menuId))
        {
            return warn("the child menu exists, not allowed to be deleted");
        }
        if (menuService.checkMenuExistRole(menuId))
        {
            return warn("the menu was already assigned, not allowed to be deleted");
        }
        return toAjax(menuService.deleteMenuById(menuId));
    }
}