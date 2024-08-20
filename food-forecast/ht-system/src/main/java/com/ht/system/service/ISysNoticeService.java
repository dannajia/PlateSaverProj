package com.ht.system.service;

import java.util.List;
import com.ht.system.domain.SysNotice;

/**
 * ISysNoticeService interface
 * 
 * @author DJ
 */
public interface ISysNoticeService
{
    /**
     * select Notice by Id
     * 
     * @param noticeId 
     * @return 
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * select notice list
     * 
     * @param notice
     * @return 
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * inset notice
     * 
     * @param notice 
     * @return
     */
    public int insertNotice(SysNotice notice);

    /**
     * update notice
     * 
     * @param notice 
     * @return 
     */
    public int updateNotice(SysNotice notice);

    /**
     * delete notice by id
     * 
     * @param noticeId 
     * @return 
     */
    public int deleteNoticeById(Long noticeId);
    
    /**
     * delete Notice By Ids
     * 
     * @param noticeIds 
     * @return 
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}
