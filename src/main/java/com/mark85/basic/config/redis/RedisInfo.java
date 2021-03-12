package com.mark85.basic.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redis动态数据
 *
 * @author zhangzichen
 * @date 2021/03/11 13:42
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisInfo {
    /**
     * Redis数据库索引（默认为0）
     */
    private int database;

    /**
     * 主机ip
     */
    private String host;

    /**
     * 端口号
     */
    private int port;

    /**
     * 密码
     */
    private String password;

    /**
     * 连接超时时间（毫秒）
     */
    private String timeout;
}
