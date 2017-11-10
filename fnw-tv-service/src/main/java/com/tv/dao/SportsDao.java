package com.tv.dao;

import com.tv.model.Lines;
import com.tv.model.HotMatch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by HUXU on 2017/10/29.
 * @author huxu
 */
@Repository
public interface SportsDao {

    /**
     * 体育赛事查询
     * @return
     */
    List<HotMatch> selSportsList();

    List<Lines> selLineList(@Param("id") String id);
}
