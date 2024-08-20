package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysPost;

/**
 * SysPostMapper interface
 * 
 * @author DJ
 */
public interface SysPostMapper
{
    /**
     * selectPostList() method
     * 
     * @param post 
     * @return 
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * selectPostAll method
     * 
     * @return 
     */
    public List<SysPost> selectPostAll();

    /**
     * selectPostById method
     * 
     * @param postId 
     * @return 
     */
    public SysPost selectPostById(Long postId);

    /**
     * selectPostListByUserId method
     * 
     * @param userId
     * @return
     */
    public List<Long> selectPostListByUserId(Long userId);

    /**
     * selectPostsByUserName method
     * 
     * @param userName 
     * @return 
     */
    public List<SysPost> selectPostsByUserName(String userName);

    /**
     * deletePostById() method
     * 
     * @param postId 
     * @return 
     */
    public int deletePostById(Long postId);

    /**
     * deletePostByIds() method
     * 
     * @param postIds
     * @return 
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * updatePost() method
     * 
     * @param post 
     * @return 
     */
    public int updatePost(SysPost post);

    /**
     * insertPost method
     * 
     * @param post 
     * @return 
     */
    public int insertPost(SysPost post);

    /**
     * checkPostNameUnique() method
     * 
     * @param postName 
     * @return 
     */
    public SysPost checkPostNameUnique(String postName);

    /**
     * checkPostCodeUnique() method
     * 
     * @param postCode 
     * @return 
     */
    public SysPost checkPostCodeUnique(String postCode);
}
