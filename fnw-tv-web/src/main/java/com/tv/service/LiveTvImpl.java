package com.tv.service;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.cache.CacheTemplateService;
import com.tv.common.Const;
import com.tv.common.KeyPre;
import com.tv.provider.LiveTvProvider;
import com.alibaba.dubbo.config.annotation.Reference;
import com.reger.dubbo.annotation.Inject;
import com.tv.util.FnwStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 视频直播实现
 *
 * @author huxu
 * @create 2017-10-30 16:34
 **/
@Service
public class LiveTvImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheTemplateService cacheTemplateService;

    //@Inject
    @Reference
    public LiveTvProvider liveTvProvider;

    @Cacheable(value="localCache", key="'selLiveTvList_'+#isHot+'_'+#liveType",sync=true)
    public Object selLiveTvList(Short liveType, Short isHot) {
        String key = FnwStr.join(KeyPre.KEY_LIVETV, liveType, Const.COLON, isHot);
        return cacheTemplateService.findSetCacheStr(key, 7, TimeUnit.DAYS, () -> {
            return liveTvProvider.selLiveTvList(liveType, isHot);
        });
    }

    @Cacheable(value="localCache", key = "'selLiveVipList_selLiveVipList'", sync=true)
    public Object selLiveVipList() {
        System.out.println("查询本地缓存");
        String key = KeyPre.KEY_LIVEVIP;
        return cacheTemplateService.findSetCacheStr(key, 7, TimeUnit.DAYS, () -> {
            return liveTvProvider.selLiveVipList();
        });
    }
}
