package com.mark85.basic.base;

/**
 * 通用实体
 *
 * @author zhangzichen
 * @date 2021/03/10 12:45
 */
public abstract class BaseEntity<T> {

    /**
     * 获取实例
     * @return 返回实体类
     */
    public abstract T buildEntity();
}
