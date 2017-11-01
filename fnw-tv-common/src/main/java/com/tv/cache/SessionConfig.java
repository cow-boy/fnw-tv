package com.tv.cache;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by HUXU on 2017/7/18.
 */

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)   //失效时间
public class SessionConfig {
}
