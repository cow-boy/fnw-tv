package com.tv.controller;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.service.SportsImpl;
import com.tv.service.SysTvImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频直播
 *
 * @author huxu
 * @create 2017-10-30 16:29
 **/
@Api(value = "体育接口", description = "体育赛事类")
@RestController
@RequestMapping("spt")
public class SportsController {

    @Autowired
    private SportsImpl sportsImpl;

    @ApiOperation(value = "体育赛事")
    @PostMapping("/spts")
    public Object spts(){
        return sportsImpl.selSportsList();
    }


}
