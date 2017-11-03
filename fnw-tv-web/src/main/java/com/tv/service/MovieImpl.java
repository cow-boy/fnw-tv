package com.tv.service;/**
 * Created by HUXU on 2017/10/30.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.tv.cache.CacheTemplateService;
import com.tv.common.Const;
import com.tv.common.KeyPre;
import com.tv.provider.MovieProvider;
import com.tv.provider.SysTvProvider;
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
public class MovieImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheTemplateService cacheTemplateService;

    //@Inject
    @Reference
    private MovieProvider movieProvider;

    @Cacheable(value="localCache", key="'selMvList_'+#type+'_'+#code",sync=true)
    public Object selMvList(Integer type, Integer code) {
        String key = FnwStr.join(KeyPre.KEY_MOVIE, type, Const.COLON, code);
        return cacheTemplateService.findSetCacheStr(key, 7, TimeUnit.DAYS, () -> {
            return movieProvider.selMvList(type, code, null);
        });
    }
}
