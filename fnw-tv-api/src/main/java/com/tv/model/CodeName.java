package com.tv.model;/**
 * Created by huxu on 2017/11/3.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 键值
 *
 * @author HUXU
 * @create 2017-11-03 22:00
 **/
@Data
public class CodeName implements Serializable{
    private static final long serialVersionUID = -2441395596509104764L;

    private String code;

    private String name;
}
