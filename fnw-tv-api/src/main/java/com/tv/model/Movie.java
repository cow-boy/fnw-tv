package com.tv.model;/**
 * Created by HUXU on 2017/11/2.
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电影
 *
 * @author huxu
 * @create 2017-11-02 15:51
 **/
@Data
public class Movie implements Serializable{

    private static final long serialVersionUID = 4252918389733323238L;

    private Integer id;

    /**
     * 来源，腾讯、搜狐、优酷
     */
    private Integer source;

    /**
     * 可以直接播放，不可直接播放
     */
    private Integer type;

    /**
     * 默认线路
     */
    private String line;

    /**
     * 类别code
     */
    private Integer code;

    /**
     * 译名
     */
    private String translation;

    /**
     * 片名
     */
    private String title;

    /**
     * 副标题
     */
    private String sub;

    /**
     * 年代
     */
    private String age;

    /**
     * 地区
     */
    private String origin;

    /**
     * 类别
     */
    private String category;

    /**
     * 语言
     */
    private String language;

    /**
     * 字幕
     */
    private String subTitle;

    /**
     * 上映时间
     */
    private String releaseDate;

    /**
     * 豆瓣评分
     */
    private String watercressScore;

    /**
     * IMDb评分
     */
    private String IMDbScore;

    /**
     * 文件格式
     */
    private String fileFormat;

    /**
     * 视频尺寸
     */
    private String videoSize;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 片长
     */
    private String longs;

    /**
     * 导演
     */
    private String director;

    /**
     * 主演
     */
    private String toStar;

    /**
     * 简介
     */
    private String briefIntroduction;

    /**
     * 封面图片
     */
    private String pic;

    /**
     * 时间
     */
    private Date creatTime;

    /**
     * 排序
     */
    private Integer sorts;

    /**
     * 视频地址
     */
    private String link;
}
