package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysUserPost;

/**
 * SysUserPostMapper interface
 * 
 * @author DJ
 */
public interface SysUserPostMapper
{
    /**
     * deleteUserPostByUserId() method
     * 
     * @param userId 
     * @return 
     */
    public int deleteUserPostByUserId(Long userId);

    /**
     * countUserPostById() method
     * 
     * @param postId 
     * @return 
     */
    public int countUserPostById(Long postId);

    /**
     * deleteUserPost method
     * 
     * @param ids 
     * @return 
     */
    public int deleteUserPost(Long[] ids);

    /**
     * batchUserPost method
     * 
     * @param userPostList 
     * @return 
     */
    public int batchUserPost(List<SysUserPost> userPostList);
}
