package com.tv.controller;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.service.LiveTvImpl;
import com.tv.service.SysTvImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "系统接口", description = "系统配置类")
@RestController
@RequestMapping("sys")
public class SysTvController {

    @Autowired
    private SysTvImpl sysTvImpl;

    @ApiOperation(value = "头部导航")
    @PostMapping("/navTv")
    public Object navTv(){
        return sysTvImpl.selnavTvList();
    }


}
