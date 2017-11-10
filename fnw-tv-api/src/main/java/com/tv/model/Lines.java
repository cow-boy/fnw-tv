package com.tv.model;/**
 * Created by HUXU on 2017/11/10.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 线路
 *
 * @author huxu
 * @create 2017-11-10 16:59
 **/
@Data
public class Lines implements Serializable{
    private static final long serialVersionUID = -463286382599494320L;

    private Integer id;

    private String sptId;

    private String line;

    private String lineName;
}
