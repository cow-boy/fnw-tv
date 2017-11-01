package com.tv.controller;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.service.LiveTvImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "电视直播数据")
    @PostMapping("/liveTv")
    //@RequestParam(value = "liveType", required = false) short liveType, @RequestParam(value = "isHot", required = false) short isHot
    public Object liveTv(){
        Object s = liveTv.selLiveTvList(null, null);
        return s;
    }

}
