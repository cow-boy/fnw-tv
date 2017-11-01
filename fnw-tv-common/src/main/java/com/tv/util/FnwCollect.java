package com.tv.util;/**
 * Created by HUXU on 2017/10/30.
 */

import java.util.Collection;
import java.util.Map;

/**
 * 判断集合
 *
 * @author huxu
 * @create 2017-10-30 11:35
 **/

public final class FnwCollect {

    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null) || collection.isEmpty();
    }

    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Map map) {
        return (map == null) || map.isEmpty();
    }

    /**
     * 判断是否不为空.
     */
    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断是否不为空.
     */
    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    private FnwCollect() {
    }
}
