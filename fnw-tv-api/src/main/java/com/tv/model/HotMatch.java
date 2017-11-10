package com.tv.model;/**
 * Created by HUXU on 2017/10/22.
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 热门赛事
 *
 * @author huxu
 * @create 2017-10-22 10:15
 **/
@Data
public class HotMatch implements Serializable{

    private static final long serialVersionUID = 5579433970860718241L;

    private String label;
    private String id;
    private String dataTime;
    private String homeTeam;
    private String homePic;
    private String guestTeam;
    private String guestPic;
    private String title;
    private String matchType;
    private String hTime;
    private Date curTime;
    private List<Lines> lines;
}
