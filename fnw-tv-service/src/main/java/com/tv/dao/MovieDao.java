package com.tv.dao;

import com.tv.model.Movie;
import com.tv.model.SysNav;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by HUXU on 2017/10/29.
 * @author huxu
 */
@Repository
public interface MovieDao {

    /**
     * 电影列表
     * @param type     可以直接播放，不可直接播放
     * @param code     类别code
     * @param search   搜索
     * @return
     */
    List<Movie> selMvList(Integer type, Integer code, String search);
}
