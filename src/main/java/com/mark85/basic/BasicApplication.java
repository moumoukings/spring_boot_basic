package com.mark85.basic;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动类
 * DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
 *
 * @author zhangzichen
 * @date 2021/03/10 13:09
 */
@ImportResource("classpath:applicationContext-basic.xml")
@SpringBootApplication(
        scanBasePackages = {
                "com.mark85.basic.config",
                "com.mark85.basic.controller",
                "com.mark85.basic.service",},
        exclude = {MybatisPlusAutoConfiguration.class})
//@MapperScan("com.mark85.basic.mapper")
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

}
