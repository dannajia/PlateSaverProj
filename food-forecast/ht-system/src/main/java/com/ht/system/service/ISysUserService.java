package com.ht.system.service;

import java.util.List;
import com.ht.common.core.domain.entity.SysUser;

/**
 * ISysUserService interface
 * 
 * @author DJ
 */
public interface ISysUserService
{
    /**
     * selectUserList method
     * 
     * @param user 
     * @return 
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * selectAllocatedList method
     * 
     * @param user 
     * @return 
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * selectUnallocatedList method
     * 
     * @param user 
     * @return 
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * selectUserByUserName method
     * 
     * @param userName 
     * @return
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * selectUserById method
     * 
     * @param userId 
     * @return 
     */
    public SysUser selectUserById(Long userId);

    /**
     * selectUserRoleGroup method
     * 
     * @param userName 
     * @return 
     */
    public String selectUserRoleGroup(String userName);

    /**
     * selectUserPostGroup method
     * 
     * @param userName 
     * @return 
     */
    public String selectUserPostGroup(String userName);

    /**
     * checkUserNameUnique method
     * 
     * @param user 
     * @return 
     */
    public boolean checkUserNameUnique(SysUser user);

    /**
     * checkPhoneUnique method
     *
     * @param user 
     * @return 
     */
    public boolean checkPhoneUnique(SysUser user);

    /**
     * checkEmailUnique method
     *
     * @param user 
     * @return 
     */
    public boolean checkEmailUnique(SysUser user);

    /**
     * checkUserAllowed method
     * 
     * @param user 
     */
    public void checkUserAllowed(SysUser user);

    /**
     * checkUserDataScope method
     * 
     * @param userId 
     */
    public void checkUserDataScope(Long userId);

    /**
     * insertUser method
     * 
     * @param user 
     * @return 
     */
    public int insertUser(SysUser user);

    /**
     * registerUser method
     * 
     * @param user 
     * @return 
     */
    public boolean registerUser(SysUser user);

    /**
     * updateUser method
     * 
     * @param user 
     * @return
     */
    public int updateUser(SysUser user);

    /**
     * insertUserAuth method
     * 
     * @param userId 
     * @param roleIds 
     */
    public void insertUserAuth(Long userId, Long[] roleIds);

    /**
     * updateUserStatus method
     * 
     * @param user 
     * @return 
     */
    public int updateUserStatus(SysUser user);

    /**
     * updateUserProfile method
     * 
     * @param user 
     * @return 
     */
    public int updateUserProfile(SysUser user);

    /**
     * updateUserAvatar method
     * 
     * @param userName 
     * @param avatar 
     * @return 
     */
    public boolean updateUserAvatar(String userName, String avatar);

    /**
     * resetPwd method
     * 
     * @param user 
     * @return
     */
    public int resetPwd(SysUser user);

    /**
     * resetUserPwd method
     * 
     * @param userName 
     * @param password 
     * @return 
     */
    public int resetUserPwd(String userName, String password);

    /**
     * deleteUserById method
     * 
     * @param userId 
     * @return 
     */
    public int deleteUserById(Long userId);

    /**
     * deleteUserByIds method
     * 
     * @param userIds 
     * @return 
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * importUser method
     * 
     * @param userList 
     * @param isUpdateSupport
     * @param operName 
     * @return 
     */
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName);

    public int realDeleteUserById(Long id);
}
