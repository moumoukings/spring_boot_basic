package com.mark85.basic.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis配置类
 *
 * @author zhangzichen
 * @date 2021/03/11 13:47
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({RedisDefaultInfo.class, RedisInfo.class})
public class RedisConfiguration {

    @Autowired
    private RedisDefaultInfo redisDefaultInfo;

    @Autowired
    private RedisInfo redisInfo;

    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        log.info("JedisPool注入成功！！");
        int database = redisInfo.getDatabase();
        String host = redisInfo.getHost();
        int port = redisInfo.getPort();
        String password = redisInfo.getPassword();
        String timeout = redisInfo.getTimeout();
        log.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisDefaultInfo.getMaxActive());
        String waitTime = redisDefaultInfo.getMaxWait().substring(0, redisDefaultInfo.getMaxWait().length() - 2);
        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(waitTime));
        jedisPoolConfig.setMaxIdle(redisDefaultInfo.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisDefaultInfo.getMinIdle());
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(true);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port,
                Integer.parseInt(timeout.substring(0, timeout.length() - 2)), password, database);
        return jedisPool;
    }

    /**
     * todo 测试
     */


}
