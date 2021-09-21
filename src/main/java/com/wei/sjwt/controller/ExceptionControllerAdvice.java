package com.wei.sjwt.controller;

import com.wei.sjwt.enums.ResultCode;
import com.wei.sjwt.exception.ApiException;
import com.wei.sjwt.model.vo.ResultVo;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResultVo<String> apiExceptionHandler(ApiException e) {
        return new ResultVo<>(e.getResultCode(), e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVo<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

}