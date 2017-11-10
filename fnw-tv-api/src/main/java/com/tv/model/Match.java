package com.tv.model;/**
 * Created by HUXU on 2017/11/10.
 */

import java.io.Serializable;
import java.util.List;

/**
 * 赛事
 *
 * @author huxu
 * @create 2017-11-10 17:35
 **/

public class Match implements Serializable{
    private static final long serialVersionUID = -9117556359922317600L;

    private String rq;

    private List<HotMatch> matchs;
}
