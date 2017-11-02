package com.tv.controller;/**
 * Created by HUXU on 2017/10/30.
 */

import com.github.benmanes.caffeine.cache.Caffeine;
import com.tv.service.LiveTvImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频直播
 *
 * @author huxu
 * @create 2017-10-30 16:29
 **/
@Api(value = "视频接口", description = "视频直播类")
@RestController
@RequestMapping("tv")
public class LiveTvController {

    @Autowired
    private LiveTvImpl liveTv;

    @ApiOperation(value = "电视直播源")
    @PostMapping("/liveTv")
    public Object liveTv(@RequestParam(value = "liveType", required = false) Short liveType, @RequestParam(value = "isHot", required = false) Short isHot){
        return liveTv.selLiveTvList(null, null);
    }

    @ApiOperation(value = "VIP视频解析")
    @PostMapping("/liveVip")
    public Object liveVip(){
        return liveTv.selLiveVipList();
    }



    @CacheEvict(value="localCache", allEntries=true)
    @ApiOperation(value = "清除本地缓存")
    @PostMapping("/deleteCache")
    public void deleteCache() {
        System.out.println("hello andCache deleteall");
    }

}
