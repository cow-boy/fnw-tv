package com.tv.service;/**
 * Created by HUXU on 2017/10/30.
 */

import com.tv.provider.LiveTvProvider;
import com.alibaba.dubbo.config.annotation.Reference;
import com.reger.dubbo.annotation.Inject;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

/**
 * 视频直播实现
 *
 * @author huxu
 * @create 2017-10-30 16:34
 **/
@Component
public class LiveTvImpl {

    @Reference
    public LiveTvProvider liveTvProvider;

    public Object selLiveTvList(Short liveType, Short isHot) {

        Object o = liveTvProvider.selLiveTvList(liveType, isHot);

        return o;
    }
}
