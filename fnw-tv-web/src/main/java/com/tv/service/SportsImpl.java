package com.tv.service;/**
 * Created by HUXU on 2017/10/30.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.tv.cache.CacheTemplateService;
import com.tv.common.KeyPre;
import com.tv.provider.SportsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 体育赛事实现
 *
 * @author huxu
 * @create 2017-10-30 16:34
 **/
@Service
public class SportsImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheTemplateService cacheTemplateService;

    //@Inject
    @Reference
    private SportsProvider sportsProvider;

    @Cacheable(value="localCache", key = "'localCache_SportsImpl_selSportsList'", sync=true)
    public Object selSportsList() {
        String key = KeyPre.KEY_SPORTS;
        return cacheTemplateService.findSetCacheStr(key, 6, TimeUnit.HOURS, () -> {
            return sportsProvider.selSportsList();
        });
    }
}
