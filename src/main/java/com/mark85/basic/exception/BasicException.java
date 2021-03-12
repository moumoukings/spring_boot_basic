package com.mark85.basic.exception;

import com.mark85.basic.enums.BasicErrorCodeEnum;

public class BasicException extends BaseException {

    private String errorCode;

    private String errorMessage;

    private String detailErrorMessage;

    public BasicException(Throwable e) {
        super(e.getMessage());
        this.errorCode = e.getMessage();
    }

    public BasicException(BasicErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
    }

    public BasicException(BasicErrorCodeEnum errorCodeEnum, String detailErrorMessage) {
        super(errorCodeEnum.getErrCode());
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailErrorMessage = detailErrorMessage;
    }

    public BasicException(String errorCode, String errorMessage, String detailErrorMessage, Throwable e) {
        super(errorCode, e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage = detailErrorMessage;
    }

    public BasicException(String errorCode, String errorMessage, String detailErrorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailErrorMessage = detailErrorMessage;
    }

    public BasicException(String errorCode, String errorMessage, Throwable e) {
        super(errorCode, e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BasicException(String errorCode, String errorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BasicException(String errorCode, Throwable e) {
        super(errorCode, e);
        this.errorCode = errorCode;
    }

    public BasicException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getDetailErrorMessage() {
        return detailErrorMessage;
    }

}
