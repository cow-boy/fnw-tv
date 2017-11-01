package com.tv.provider;

/**
 * Created by HUXU on 2017/10/29.
 * 电视直播接口
 */
public interface LiveTvProvider {

    /**
     * 电视直播数据
     * @param liveType  直播类型，CCTV、卫视、港澳台、海外
     * @param isHot     是否热门， 默认0， 1热门
     * @return
     */
    Object selLiveTvList(Short liveType, Short isHot);

    /**
     * VIP视频解析路径
     * @return
     */
    Object selLiveVipList();

}
