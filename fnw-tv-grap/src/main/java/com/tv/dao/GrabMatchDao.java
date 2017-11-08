package com.tv.dao;

import com.tv.model.HotMatch;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HUXU on 2017/11/8.
 */
@Repository
public interface GrabMatchDao {

    void addHotMatch(List<HotMatch> list);

}
