package com.tv.controller;/**
 * Created by HUXU on 2017/10/30.
 */

import com.alibaba.fastjson.JSON;
import com.tv.model.HotMatch;
import com.tv.service.SportsImpl;
import com.tv.service.SysTvImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 视频直播
 *
 * @author huxu
 * @create 2017-10-30 16:29
 **/
@Api(value = "体育接口", description = "体育赛事类")
@Controller
@RequestMapping("spt")
public class SportsController {

    @Autowired
    private SportsImpl sportsImpl;

    @ApiOperation(value = "体育赛事")
    @PostMapping("/spts")
    @ResponseBody
    public Object spts(){
        String o = sportsImpl.selSportsList();
        Map<String, List<HotMatch>> map = JSON.parseObject(o, Map.class);
        Map<String, List<HotMatch>> finalMap = new TreeMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, List<HotMatch>>comparingByKey()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        return JSON.toJSON(finalMap);
    }

    @RequestMapping(value = "/tv/{id}.html", method = {RequestMethod.GET})
    public ModelAndView topScorer(Model model, HttpServletRequest request, @PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("/demo");
        return modelAndView;
    }

}
