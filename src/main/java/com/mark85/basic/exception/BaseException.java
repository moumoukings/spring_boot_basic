package com.mark85.basic.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract String getErrorCode();

    public abstract String getErrorMessage();

    public abstract String getDetailErrorMessage();

}
