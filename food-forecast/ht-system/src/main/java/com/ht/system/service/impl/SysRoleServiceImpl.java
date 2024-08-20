package com.ht.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ht.common.annotation.DataScope;
import com.ht.common.constant.UserConstants;
import com.ht.common.core.domain.entity.SysRole;
import com.ht.common.core.domain.entity.SysUser;
import com.ht.common.exception.ServiceException;
import com.ht.common.utils.SecurityUtils;
import com.ht.common.utils.StringUtils;
import com.ht.common.utils.spring.SpringUtils;
import com.ht.system.domain.SysRoleDept;
import com.ht.system.domain.SysRoleMenu;
import com.ht.system.domain.SysUserRole;
import com.ht.system.mapper.SysRoleDeptMapper;
import com.ht.system.mapper.SysRoleMapper;
import com.ht.system.mapper.SysRoleMenuMapper;
import com.ht.system.mapper.SysUserRoleMapper;
import com.ht.system.service.ISysRoleService;

/**
 * SysRoleServiceImpl class
 * 
 * @author DJ
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService
{
    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleDeptMapper roleDeptMapper;

    /**
     * selectRoleList method
     * 
     * @param role 
     * @return 
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysRole> selectRoleList(SysRole role)
    {
        return roleMapper.selectRoleList(role);
    }

    /**
     * selectRolesByUserId method
     * 
     * @param userId 
     * @return 
     */
    @Override
    public List<SysRole> selectRolesByUserId(Long userId)
    {
        List<SysRole> userRoles = roleMapper.selectRolePermissionByUserId(userId);
        List<SysRole> roles = selectRoleAll();
        for (SysRole role : roles)
        {
            for (SysRole userRole : userRoles)
            {
                if (role.getRoleId().longValue() == userRole.getRoleId().longValue())
                {
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    /**
     * selectRolePermissionByUserId method
     * 
     * @param userId 
     * @return 
     */
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId)
    {
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * selectRoleAll method
     * 
     * @return 
     */
    @Override
    public List<SysRole> selectRoleAll()
    {
        return SpringUtils.getAopProxy(this).selectRoleList(new SysRole());
    }

    /**
     * selectRoleListByUserId method
     * 
     * @param userId 
     * @return 
     */
    @Override
    public List<Long> selectRoleListByUserId(Long userId)
    {
        return roleMapper.selectRoleListByUserId(userId);
    }

    /**
     * selectRoleById method
     * 
     * @param roleId 
     * @return 
     */
    @Override
    public SysRole selectRoleById(Long roleId)
    {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * checkRoleNameUnique method
     * 
     * @param role 
     * @return 
     */
    @Override
    public boolean checkRoleNameUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * checkRoleKeyUnique method
     * 
     * @param role 
     * @return 
     */
    @Override
    public boolean checkRoleKeyUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * checkRoleAllowed method
     * 
     * @param role 
     */
    @Override
    public void checkRoleAllowed(SysRole role)
    {
        if (StringUtils.isNotNull(role.getRoleId()) && role.isAdmin())
        {
            throw new ServiceException("It is not allowed to perform the Admin Role");
        }
    }

    /**
     * checkRoleDataScope method
     * 
     * @param roleId 
     */
    @Override
    public void checkRoleDataScope(Long roleId)
    {
        if (!SysUser.isAdmin(SecurityUtils.getUserId()))
        {
            SysRole role = new SysRole();
            role.setRoleId(roleId);
            List<SysRole> roles = SpringUtils.getAopProxy(this).selectRoleList(role);
            if (StringUtils.isEmpty(roles))
            {
                throw new ServiceException("no permission to access the data！");
            }
        }
    }

    /**
     * countUserRoleByRoleId method
     * 
     * @param roleId 
     * @return 
     */
    @Override
    public int countUserRoleByRoleId(Long roleId)
    {
        return userRoleMapper.countUserRoleByRoleId(roleId);
    }

    /**
     * insertRole method
     * 
     * @param role 
     * @return 
     */
    @Override
    @Transactional
    public int insertRole(SysRole role)
    {
        
        roleMapper.insertRole(role);
        return insertRoleMenu(role);
    }

    /**
     * updateRole method
     * 
     * @param role 
     * @return 
     */
    @Override
    @Transactional
    public int updateRole(SysRole role)
    {
        
        roleMapper.updateRole(role);
        
        roleMenuMapper.deleteRoleMenuByRoleId(role.getRoleId());
        return insertRoleMenu(role);
    }

    /**
     * updateRoleStatus method
     * 
     * @param role 
     * @return 
     */
    @Override
    public int updateRoleStatus(SysRole role)
    {
        return roleMapper.updateRole(role);
    }

    /**
     * authDataScope method
     * 
     * @param role 
     * @return 
     */
    @Override
    @Transactional
    public int authDataScope(SysRole role)
    {
        
        roleMapper.updateRole(role);
        
        roleDeptMapper.deleteRoleDeptByRoleId(role.getRoleId());
        
        return insertRoleDept(role);
    }

    /**
     * insertRoleMenu method
     * 
     * @param role 
     */
    public int insertRoleMenu(SysRole role)
    {
        int rows = 1;
        
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (Long menuId : role.getMenuIds())
        {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0)
        {
            rows = roleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }

    /**
     * insertRoleDept method
     *
     * @param role 
     */
    public int insertRoleDept(SysRole role)
    {
        int rows = 1;
        
        List<SysRoleDept> list = new ArrayList<SysRoleDept>();
        for (Long deptId : role.getDeptIds())
        {
            SysRoleDept rd = new SysRoleDept();
            rd.setRoleId(role.getRoleId());
            rd.setDeptId(deptId);
            list.add(rd);
        }
        if (list.size() > 0)
        {
            rows = roleDeptMapper.batchRoleDept(list);
        }
        return rows;
    }

    /**
     * deleteRoleById method
     * 
     * @param roleId 
     * @return 
     */
    @Override
    @Transactional
    public int deleteRoleById(Long roleId)
    {
        
        roleMenuMapper.deleteRoleMenuByRoleId(roleId);
        
        roleDeptMapper.deleteRoleDeptByRoleId(roleId);
        return roleMapper.deleteRoleById(roleId);
    }

    /**
     * deleteRoleByIds method
     * 
     * @param roleIds 
     * @return 
     */
    @Override
    @Transactional
    public int deleteRoleByIds(Long[] roleIds)
    {
        for (Long roleId : roleIds)
        {
            checkRoleAllowed(new SysRole(roleId));
            checkRoleDataScope(roleId);
            SysRole role = selectRoleById(roleId);
            if (countUserRoleByRoleId(roleId) > 0)
            {
                throw new ServiceException(String.format("%1$s are already assigned, and can't be deleted", role.getRoleName()));
            }
        }
        
        roleMenuMapper.deleteRoleMenu(roleIds);
        
        roleDeptMapper.deleteRoleDept(roleIds);
        return roleMapper.deleteRoleByIds(roleIds);
    }

    /**
     * deleteAuthUser method
     * 
     * @param userRole 
     * @return 
     */
    @Override
    public int deleteAuthUser(SysUserRole userRole)
    {
        return userRoleMapper.deleteUserRoleInfo(userRole);
    }

    /**
     * deleteAuthUsers method
     * 
     * @param roleId 
     * @param userIds 
     * @return 
     */
    @Override
    public int deleteAuthUsers(Long roleId, Long[] userIds)
    {
        return userRoleMapper.deleteUserRoleInfos(roleId, userIds);
    }

    /**
     * insertAuthUsers method
     * 
     * @param roleId 
     * @param userIds 
     * @return 
     */
    @Override
    public int insertAuthUsers(Long roleId, Long[] userIds)
    {
        
        List<SysUserRole> list = new ArrayList<SysUserRole>();
        for (Long userId : userIds)
        {
            SysUserRole ur = new SysUserRole();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        return userRoleMapper.batchUserRole(list);
    }
}
