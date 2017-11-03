package com.tv.provider;

/**
 * Created by HUXU on 2017/10/29.
 * 系统配置接口
 */
public interface MovieProvider {

    /**
     *
     * @param type     可以直接播放，不可直接播放
     * @param code     类别code
     * @param search   搜索
     * @return
     */
    Object selMvList(Integer type, Integer code, String search);

}
