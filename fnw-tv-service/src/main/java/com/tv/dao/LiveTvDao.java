package com.tv.dao;

import com.tv.model.LiveLine;
import com.tv.model.LiveTv;
import com.tv.model.LiveVip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by HUXU on 2017/10/29.
 * @author huxu
 */
@Repository
public interface LiveTvDao {

    /**
     * 电视直播查询
     * @param liveType
     * @param isHot
     * @return
     */
    List<LiveTv> selLiveTvList(@Param("liveType") Short liveType, @Param("isHot") Short isHot);

    /**
     * 电视直播源查询
     * @param id
     * @return
     */
    List<LiveLine> selLiveLine(@Param("id") Integer id);

    /**
     * VIP视频播放源查询
     * @return
     */
    List<LiveVip> selLiveVipList();
}
