package com.tv.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by HUXU on 2017/4/8.
 * @author huxu
 */
@Repository
public class CacheTemplateService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 该方法只取不存
     *
     * @param key      缓存的key
     * @param clazz    缓存的类型
     * @param loadBack 缓存失效如何获取
     * @param <T>
     * @return
     */
    public <T> T findCache(String key, TypeReference<T> clazz, CacheLoadback<T> loadBack) {
        String json = redisTemplate.opsForValue().get(key) + "";
        if (StringUtils.isNoneEmpty(json) && !json.equalsIgnoreCase("null")) {
            return JSON.parseObject(json, clazz);
        } else {
            synchronized (this) {
                json = redisTemplate.opsForValue().get(key) + "";
                if (StringUtils.isNoneEmpty(json) && !json.equalsIgnoreCase("null")) {
                    return JSON.parseObject(json, clazz);
                }
                T result = loadBack.load();
                return result;
            }
        }
    }

    /**
     * 该方法取存
     *
     * @param key      缓存的key
     * @param time     缓存的失效时间值
     * @param timeu    缓存的失效时间单位
     * @param clazz    缓存的类型
     * @param loadBack 缓存失效如何获取
     * @param <T>
     * @return
     */
    public <T> T findSetCache(String key, Integer time, TimeUnit timeu, TypeReference<T> clazz, CacheLoadback<T> loadBack) {
        String json = redisTemplate.opsForValue().get(key) + "";
        if (StringUtils.isNoneEmpty(json) && !json.equalsIgnoreCase("null")) {
            return JSON.parseObject(json, clazz);
        } else {
            synchronized (this) {
                json = redisTemplate.opsForValue().get(key) + "";
                if (StringUtils.isNoneEmpty(json) && !json.equalsIgnoreCase("null")) {
                    return JSON.parseObject(json, clazz);
                }
                T result = loadBack.load();
                if (result != null) {
                    redisTemplate.opsForValue().set(key, JSON.toJSON(result), time, timeu);
                }
                return result;
            }
        }
    }

}
