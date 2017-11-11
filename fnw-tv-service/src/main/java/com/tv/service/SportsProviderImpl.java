package com.tv.service;/**
 * Created by HUXU on 2017/10/29.
 */


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tv.cache.CacheTemplateService;
import com.tv.common.KeyPre;
import com.tv.dao.SportsDao;
import com.tv.model.HotMatch;
import com.tv.model.Lines;
import com.tv.provider.SportsProvider;
import com.tv.util.Group2Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;


/**
 * 电视视频直播
 *
 * @author huxu
 * @create 2017-10-29 17:36
 **/
@Service(protocol="dubbo")
public class SportsProviderImpl implements SportsProvider {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheTemplateService cacheTemplateService;

    @Autowired
    private SportsDao sportsDao;

    @Override
    public Map<String, List<HotMatch>> selSportsList() {
        String key = KeyPre.KEY_SPORTS;
        List<HotMatch> list = cacheTemplateService.findSetCache(key, 6, TimeUnit.HOURS, new TypeReference<List<HotMatch>>(){
        }, () -> {
            List<HotMatch> hotMatches = sportsDao.selSportsList();
            hotMatches.forEach(hotMatch -> {
                List<Lines> line = sportsDao.selLineList(hotMatch.getId());
                hotMatch.setLines(line);
            });
            return hotMatches;
        });
        Map<String, List<HotMatch>> map = new HashMap<>();
        Group2Map.listGroup2Map(list, map, HotMatch.class, "hTime");
        return map;
    }
}
