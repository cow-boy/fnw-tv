package com.tv.controller;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.service.MovieImpl;
import com.tv.service.SysTvImpl;
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
@Api(value = "电影接口", description = "电影类")
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieImpl movieImpl;

    @ApiOperation(value = "电影列表页")
    @PostMapping("/mvlist")
    public Object mvList(@RequestParam(value = "type", required = false) Integer type, @RequestParam(value = "code", required = false) Integer code){
        return movieImpl.selMvList(type, code);
    }


}
