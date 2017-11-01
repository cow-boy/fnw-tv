package com.tv.model;/**
 * Created by HUXU on 2017/11/1.
 */

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 系统导航
 *
 * @author huxu
 * @create 2017-11-01 16:26
 **/
@Data
public class SysNav implements Serializable {

    private Integer id;

    private Integer navId;

    private String navName;

    private String navUrl;

    private String navPic;

    private Integer navPid;

    private Integer navSort;

    private List<SysNav> sysNavs;
}
