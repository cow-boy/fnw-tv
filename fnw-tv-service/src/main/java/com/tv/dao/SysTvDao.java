package com.tv.dao;

import com.tv.model.SysNav;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by HUXU on 2017/10/29.
 * @author huxu
 */
@Repository
public interface SysTvDao {

    /**
     * VIP视频播放源查询
     * @return
     */
    List<SysNav> selSysNavList();
}
