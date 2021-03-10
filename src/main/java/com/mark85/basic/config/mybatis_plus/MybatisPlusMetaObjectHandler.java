package com.mark85.basic.config.mybatis_plus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 公共字段填充
 *
 * @author zhangzichen
 * @date 2021/03/10 13:29
 */
@Slf4j
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static boolean ISDELETED = false;
    private static int VERSION = 1;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setIfAbsent("gmtCreate", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setIfAbsent("gmtModified", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("version", VERSION, metaObject);
        this.setFieldValByName("isDeleted", ISDELETED, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        //this.strictUpdateFill(metaObject, "gmtModified", Timestamp.class, new Timestamp(System.currentTimeMillis()));
        //this.strictUpdateFill(metaObject, "version", int.class, ++VERSION);
        this.setFieldValByName("gmtModified", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("version", ++VERSION, metaObject);
    }

    private void setIfAbsent(String fieldName, Object fielfVal, MetaObject metaObject) {
        if (getFieldValByName(fieldName, metaObject) != null) {
            return;
        }
        this.setFieldValByName(fieldName, fielfVal, metaObject);
    }
}
