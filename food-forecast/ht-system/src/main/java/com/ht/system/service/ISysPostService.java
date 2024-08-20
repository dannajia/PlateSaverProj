package com.ht.system.service;

import java.util.List;
import com.ht.system.domain.SysPost;

/**
 * ISysPostService interface
 * 
 * @author DJ
 */
public interface ISysPostService
{
    /**
     * select PostList method
     * 
     * @param post 
     * @return 
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * slect PostAll method
     * 
     * @return 
     */
    public List<SysPost> selectPostAll();

    /**
     * select PostById method
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
     * checkPostNameUnique method
     * 
     * @param post 
     * @return 
     */
    public boolean checkPostNameUnique(SysPost post);

    /**
     * checkPostCodeUnique method
     * 
     * @param post 
     * @return 
     */
    public boolean checkPostCodeUnique(SysPost post);

    /**
     * countUserPostById method
     * 
     * @param postId 
     * @return 
     */
    public int countUserPostById(Long postId);

    /**
     * deletePostById method
     * 
     * @param postId 
     * @return 
     */
    public int deletePostById(Long postId);

    /**
     * deletePostByIds method
     * 
     * @param postIds 
     * @return 
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * insertPost method
     * 
     * @param post 
     * @return 
     */
    public int insertPost(SysPost post);

    /**
     * updatePost method
     * 
     * @param post 
     * @return 
     */
    public int updatePost(SysPost post);
}
