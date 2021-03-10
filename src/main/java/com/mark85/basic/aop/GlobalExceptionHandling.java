package com.mark85.basic.aop;

import com.mark85.basic.entity.vo.ResultVo;
import com.mark85.basic.enums.ResultEnum;
import com.mark85.basic.exception.CustomException;
import com.mark85.basic.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

/**
 * 全局异常处理
 *
 * @author zhangzichen
 * @date 2021/03/10 12:48
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {
    /**
     * 自定义异常
     */
    @ExceptionHandler(value = CustomException.class)
    public ResultVo processException(CustomException e) {
        log.error("位置:{} -> 错误信息:{}", e.getMethod() ,e.getLocalizedMessage());
        return ResultVoUtil.error(Objects.requireNonNull(ResultEnum.getByCode(e.getCode())));
    }

    /**
     * 拦截表单参数校验
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BindException.class})
    public ResultVo bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResultVoUtil.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    /**
     * 拦截JSON参数校验
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResultVoUtil.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultVo methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("错误信息{}", e.getLocalizedMessage());
        return ResultVoUtil.error(ResultEnum.ARGUMENT_TYPE_MISMATCH);
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultVo httpMessageNotReadable(HttpMessageNotReadableException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return ResultVoUtil.error(ResultEnum.FORMAT_ERROR);
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVo httpReqMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.error("错误信息:{}", e.getLocalizedMessage());
        return ResultVoUtil.error(ResultEnum.REQ_METHOD_NOT_SUPPORT);
    }

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResultVo exception(Exception e) {
        e.printStackTrace();
        return ResultVoUtil.error(ResultEnum.UNKNOWN_EXCEPTION);
    }
}
