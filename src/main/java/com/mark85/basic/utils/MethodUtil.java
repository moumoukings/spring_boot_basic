package com.mark85.basic.utils;

/**
 * 获取当前方法和行号
 *
 * @author zhangzichen
 * @date 2021/03/10 13:05
 */
public class MethodUtil {

    /**
     * 私有化工具类 防止被实例化
     */
    private MethodUtil() {
    }

    public static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + " -> " + ste.getLineNumber() + "行";
    }
}
