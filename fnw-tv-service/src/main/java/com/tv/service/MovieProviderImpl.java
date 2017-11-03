package com.tv.service;/**
 * Created by HUXU on 2017/10/29.
 */


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tv.cache.CacheTemplateService;
import com.tv.common.Const;
import com.tv.common.KeyPre;
import com.tv.dao.MovieDao;
import com.tv.dao.SysTvDao;
import com.tv.model.Movie;
import com.tv.model.SysNav;
import com.tv.provider.MovieProvider;
import com.tv.provider.SysTvProvider;
import com.tv.util.FnwStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 电视视频直播
 *
 * @author huxu
 * @create 2017-10-29 17:36
 **/
@Service(protocol="dubbo")
public class MovieProviderImpl implements MovieProvider {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheTemplateService cacheTemplateService;

    @Autowired
    private MovieDao movieDao;

    @Override
    public Object selMvList(Integer type, Integer code, String search) {
        String key = FnwStr.join(KeyPre.KEY_VIDEO, type, Const.COLON, code, Const.COLON, search);
        List<Movie> list = cacheTemplateService.findSetCache(key, 7, TimeUnit.DAYS, new TypeReference<List<Movie>>(){
        }, () -> {
            List<Movie> ltv = movieDao.selMvList(type, code, search);
            return ltv;
        });
        return JSON.toJSON(list);
    }
}
