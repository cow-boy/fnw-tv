package com.tv.service;/**
 * Created by HUXU on 2017/10/29.
 */


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tv.cache.CacheTemplateService;
import com.tv.common.KeyPre;
import com.tv.dao.SysTvDao;
import com.tv.model.SysNav;
import com.tv.provider.SysTvProvider;
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
        List<SysNav> list = cacheTemplateService.findSetCache(key, 7, TimeUnit.DAYS, new TypeReference<List<SysNav>>(){
        }, () -> {
            List<SysNav> sysNavs = new ArrayList<>();
            List<SysNav> ltv = sysTvDao.selSysNavList();
            for (SysNav nav: ltv) {
                List<SysNav> navs = new ArrayList<>();
                Integer navId = nav.getNavId();
                for (SysNav na: ltv) {
                    Integer navPid = na.getNavPid();
                    if (navId.equals(navPid)) {
                        navs.add(na);
                        sysNavs.add(na);
                    }
                }
                nav.setSysNavs(navs);
            }
            for(int i = ltv.size() - 1; i >= 0; i--){
                SysNav sysNav = ltv.get(i);
                if(sysNavs.contains(sysNav)){
                    ltv.remove(sysNav);
                }
            }
            return ltv;
        });
        return JSON.toJSON(list);
    }
}
