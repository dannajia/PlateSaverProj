package com.ht.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ht.common.core.domain.entity.SysUser;

/**
 * SysUserMapper interface
 *
 * @author DJ
 */
public interface SysUserMapper {
    /**
     * selectUserList() method
     *
     * @param sysUser 
     * @return 
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * selectAllocatedList() method
     *
     * @param user 
     * @return 
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * selectUnallocatedList() method
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
     * selectUserById() method
     *
     * @param userId 
     * @return 
     */
    public SysUser selectUserById(Long userId);

    /**
     * insertUser method
     *
     * @param user 
     * @return 
     */
    public int insertUser(SysUser user);

    /**
     * updateUser method
     *
     * @param user 
     * @return 
     */
    public int updateUser(SysUser user);

    /**
     * updateUserAvatar() method
     *
     * @param userName 
     * @param avatar   
     * @return 
     */
    public int updateUserAvatar(@Param("userName") String userName, @Param("avatar") String avatar);

    /**
     * resetUserPwd() method
     *
     * @param userName 
     * @param password 
     * @return 
     */
    public int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

    /**
     * deleteUserById() method
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
     * realDeleteUserById() method
     *
     * @param id
     * @return
     */
    public int realDeleteUserById(Long id);

    /**
     * checkUserNameUnique method
     *
     * @param userName 
     * @return 
     */
    public SysUser checkUserNameUnique(String userName);

    /**
     * checkUserNameUnique method
     *
     * @param phonenumber 
     * @return 
     */
    public SysUser checkPhoneUnique(String phonenumber);

    public SysUser checkPhoneExist(String phonenumber);

    /**
     * checkEmailUnique() method
     *
     * @param email 
     * @return 
     */
    public SysUser checkEmailUnique(String email);
}
