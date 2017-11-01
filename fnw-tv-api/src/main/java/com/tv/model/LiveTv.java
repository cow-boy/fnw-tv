package com.tv.model;/**
 * Created by HUXU on 2017/10/29.
 */

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 直播电视台
 *
 * @author huxu
 * @create 2017-10-29 16:28
 **/
@Data
public class LiveTv implements Serializable{

    private static final long serialVersionUID = -7566273684707361178L;

    /**
     * 电视直播Id
     */
    private Integer id;

    /**
     * 电视直播类型（cctv、卫视、港澳台、海外）
     */
    private Short liveType;

    /**
     * 是否热门（默认0， 1热门）
     */
    private Short isHot;

    /**
     * 电视直播名称代码
     */
    private Integer liveCode;

    /**
     * 电视直播名称
     */
    private String liveName;

    /**
     * 电视直播封面
     */
    private String livePic;

    /**
     * 电视直播修改时间
     */
    private String liveTime;

    /**
     * 电视直播描述
     */
    private String description;

    /**
     * 直播线路
     */
    private List<LiveLine> liveLines;

    /**
     * 电视视频排序
     */
    private Integer sort;

}
