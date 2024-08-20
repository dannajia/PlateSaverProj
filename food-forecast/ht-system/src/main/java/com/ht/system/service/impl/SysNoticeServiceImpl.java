package com.ht.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ht.system.domain.SysNotice;
import com.ht.system.mapper.SysNoticeMapper;
import com.ht.system.service.ISysNoticeService;

/**
 * SysNoticeServiceImpl class
 * 
 * @author DJ
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService
{
    @Autowired
    private SysNoticeMapper noticeMapper;

    /**
     * selectNoticeById method
     * 
     * @param noticeId 
     * @return 
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * selectNoticeList() method
     * 
     * @param notice 
     * @return 
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * insertNotice method
     * 
     * @param notice 
     * @return 
     */
    @Override
    public int insertNotice(SysNotice notice)
    {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * updateNotice() method
     * 
     * @param notice
     * @return 
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * deleteNoticeById() method
     * 
     * @param noticeId 
     * @return 
     */
    @Override
    public int deleteNoticeById(Long noticeId)
    {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    /**
     * deleteNoticeByIds() method
     * 
     * @param noticeIds 
     * @return 
     */
    @Override
    public int deleteNoticeByIds(Long[] noticeIds)
    {
        return noticeMapper.deleteNoticeByIds(noticeIds);
    }
}
