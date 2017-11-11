package com.tv.provider;

import com.tv.model.HotMatch;

import java.util.List;
import java.util.Map;

/**
 * Created by HUXU on 2017/10/29.
 * 体育赛事接口
 */
public interface SportsProvider {

    /**
     * 体育赛事
     * @return
     */
    Map<String, List<HotMatch>> selSportsList();

}
