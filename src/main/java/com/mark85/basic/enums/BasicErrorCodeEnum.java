package com.mark85.basic.enums;

public enum BasicErrorCodeEnum {

    /**
     * 非法请求
     */
    ILLGAL_REQUEST("ILLGAL_REQUEST", "非法请求"),
    /**
     * 登录验证失败
     */
    LOGIN_CHECK_ERROR("LOGIN_CHECK_ERROR", "登录验证失败"),
    /**
     * 用户不存在
     */
    NOT_FIND_UESR("NOT_FIND_UESR", "用户不存在"),
    /**
     * AES解密秘钥是空
     */
    QENCODE_DECRYPT_KEY_ISNULL("QENCODE_DECRYPT_KEY_ISNULL", "AES解密秘钥是空"),
    /**
     * AES加密秘钥是空
     */
    QENCODE_ENCRYPT_KEY_ISNULL("QENCODE_ENCRYPT_KEY_ISNULL", "AES加密秘钥是空"),
    /**
     * 登陆过期
     */
    LOGIN_TIME_OUT("LOGIN_TIME_OUT", "登陆过期"),
    /**
     * token无效
     */
    REQUEST_TOKEN_ERROR("REQUEST_TOKEN_ERROR", "token无效"),
    /**
     * 非法参数
     */
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT", "非法参数"),
    /**
     * 幂等异常
     */
    IDEMPOTENT_INVOKE("IDEMPOTENT_INVOKE", "幂等异常"),
    /**
     * 执行数据库错误
     */
    EXECUTE_SQL_ERROR("EXECUTE_SQL_ERROR", "执行数据库错误"),

    /**
     * token为null
     */
    REQUEST_TOKEN_ISNULL("REQUEST_TOKEN_ISNULL", "token为null");

    private String errMsg;

    private String errCode;

    BasicErrorCodeEnum(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    BasicErrorCodeEnum(String errCode) {
        this.errCode = errCode;
    }

    public static BasicErrorCodeEnum getDistributionErrorCodeEnum(String code) {
        for (BasicErrorCodeEnum x : BasicErrorCodeEnum.values()) {
            if (x.getErrCode().equals(code)) {
                return x;
            }
        }
        return null;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
