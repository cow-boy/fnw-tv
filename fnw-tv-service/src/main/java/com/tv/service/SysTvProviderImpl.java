package com.tv.service;/**
 * Created by HUXU on 2017/10/29.
 */


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tv.cache.CacheTemplateService;
import com.tv.common.Const;
import com.tv.common.KeyPre;
import com.tv.dao.LiveTvDao;
import com.tv.dao.SysTvDao;
import com.tv.model.LiveLine;
import com.tv.model.LiveTv;
import com.tv.model.LiveVip;
import com.tv.model.SysNav;
import com.tv.provider.LiveTvProvider;
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
public class SysTvProviderImpl implements SysTvProvider {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CacheTemplateService cacheTemplateService;

    @Autowired
    private SysTvDao sysTvDao;

    @Override
    public Object selSysNavList() {
        String key = KeyPre.KEY_TOPNAV;
  /*      List<SysNav> list = cacheTemplateService.findSetCache(key, 1, TimeUnit.SECONDS, new TypeReference<List<SysNav>>(){
        }, () -> {
            List<SysNav> ltv = sysTvDao.selSysNavList();

            for (SysNav nav: ltv) {
                Integer navId = nav.getNavId();
                for (SysNav na: ltv) {
                    Integer navPid = na.getNavPid();
                    if (navId.equals(navPid)) {
                        nav.getSysNavs().add(na);
                        ltv.remove(na);
                    }
                }
            }

            return ltv;
        });*/
        List<SysNav> ltv = sysTvDao.selSysNavList();
        for (SysNav nav: ltv) {
            List<Object> navs = new ArrayList<>();
            Integer navId = nav.getNavId();
            for (SysNav na: ltv) {
                Integer navPid = na.getNavPid();
                if (navId.equals(navPid)) {
                    navs.add(na);


                }
            }
        }
        System.out.println(ltv);
        return null;
       // return JSON.toJSON(list);
    }
}
