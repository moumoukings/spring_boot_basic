package com.mark85.basic;

import com.mark85.basic.config.redis.RedisDefaultInfo;
import com.mark85.basic.config.redis.RedisInfo;
import com.mark85.basic.config.swagger.SwaggerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试启动类
 *
 * @author zhangzichen
 * @date 2021/03/10 12:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {
    @Autowired
    private RedisInfo redisInfo;

    @Autowired
    private SwaggerInfo swaggerInfo;

    @Autowired
    private RedisDefaultInfo redisDefaultInfo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        System.out.println(redisDefaultInfo.getMaxWait());
        System.out.println(redisInfo.getDatabase()+":"+redisInfo.getHost()+":"+redisInfo.getPort()+":"+redisInfo.getPassword()+":"+redisInfo.getTimeout());
        System.out.println(swaggerInfo.getAuthor());
    }


}
