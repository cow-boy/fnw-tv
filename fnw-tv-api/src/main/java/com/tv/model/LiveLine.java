package com.tv.model;/**
 * Created by HUXU on 2017/10/29.
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 直播线路
 *
 * @author huxu
 * @create 2017-10-29 16:49
 **/
@Data
public class LiveLine implements Serializable{

    private static final long serialVersionUID = -2538179427314675996L;

    private Integer id;

    private Integer pid;

    private String line;

    private Date lineTime;

    private Short sort;

}
