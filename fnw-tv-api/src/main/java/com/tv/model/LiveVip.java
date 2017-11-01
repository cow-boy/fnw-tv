package com.tv.model;/**
 * Created by HUXU on 2017/10/30.
 */

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * vip解析地址
 *
 * @author huxu
 * @create 2017-10-30 13:57
 **/
@Data
public class LiveVip implements Serializable {

    private static final long serialVersionUID = 5498917288235718775L;

    private Integer id;

    private String vipUrl;

    private String vipDesc;

    private Integer vipSort;

}
