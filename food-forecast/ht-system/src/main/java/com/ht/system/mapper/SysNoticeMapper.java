package com.ht.system.mapper;

import java.util.List;
import com.ht.system.domain.SysNotice;

/**
 * SysNoticeMapper class
 * 
 * @author DJ
 */
public interface SysNoticeMapper
{
    /**
     * selectNoticeById() method
     * 
     * @param noticeId 
     * @return 
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * selectNoticeList() method
     * 
     * @param notice 
     * @return 
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * insertNotice() method
     * 
     * @param notice 
     * @return 
     */
    public int insertNotice(SysNotice notice);

    /**
     * updateNotice() method
     * 
     * @param notice 
     * @return 
     */
    public int updateNotice(SysNotice notice);

    /**
     * deleteNoticeById() method
     * 
     * @param noticeId 
     * @return 
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * deleteNoticeByIds() method
     * 
     * @param noticeIds 
     * @return 
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}
