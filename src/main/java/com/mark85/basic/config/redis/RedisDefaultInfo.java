package com.mark85.basic.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redis配置
 *
 * @author zhangzichen
 * @date 2021/03/11 13:23
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis.jedis.pool")
public class RedisDefaultInfo {

    /**
     * 连接池最大连接数（使用负值表示没有限制）默认
     */
    private int maxActive;

    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    private String maxWait;

    /**
     * 连接池中的最大空闲连接
     */
    private int maxIdle;

    /**
     * 连接池中的最小空闲连接
     */
    private int minIdle;
}
