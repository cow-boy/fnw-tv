package com.tv.provider;/**
 * Created by HUXU on 2017/10/29.
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.tv.cache.CacheTemplateService;
import com.tv.common.Const;
import com.tv.common.KeyPre;
import com.tv.dao.LiveTvDao;

import com.tv.model.LiveLine;
import com.tv.model.LiveTv;
import com.tv.model.LiveVip;
import com.tv.provider.LiveTvProvider;

import com.tv.util.FnwStr;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 电视视频直播
 *
 * @author huxu
 * @create 2017-10-29 17:36
 **/
@Service(protocol="dubbo")
public class LiveTvProviderImpl implements LiveTvProvider {

    @Autowired
    private CacheTemplateService cacheTemplateService;

    @Autowired
    private LiveTvDao liveTvDao;

    @Override
    public Object selLiveTvList(Short liveType, Short isHot) {

        /*String key = FnwStr.join(KeyPre.KEY_LIVETV, liveType, Const.COLON, isHot);
        List<LiveTv> list = cacheTemplateService.findSetCache(key, 7, TimeUnit.DAYS, new TypeReference<List<LiveTv>>() {
        }, () -> {
            List<LiveTv> ltv = liveTvDao.selLiveTvList(liveType, isHot);
            for (LiveTv lt: ltv) {
                List<LiveLine> lines = liveTvDao.selLiveLine(lt.getId());
                lt.setLiveLines(lines);
            }
            return ltv;
        });*/
        return "hhhhhhhh";
    }

    @Override
    public Object selLiveVipList() {
        String key = KeyPre.KEY_LIVEVIP;
        List<LiveVip> list = cacheTemplateService.findSetCache(key, 7, TimeUnit.DAYS, new TypeReference<List<LiveVip>>(){
        }, () -> {
            List<LiveVip> ltv = liveTvDao.selLiveVipList();
            return ltv;
        });
        return JSON.toJSON(list);
    }

}
