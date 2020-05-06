package com.frontier.demo.advice;

import com.frontier.demo.common.BaseResponse;
import com.frontier.demo.exception.ServiceException;
import com.frontier.demo.util.BaseResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 自定义全局异常处理器
 *
 * @author 纪云行
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * 校验异常处理
     *
     * @param methodArgumentNotValidException 方法参数校验异常
     * @return 响应实体
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<String>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error("数据参数校验异常，异常信息：{}", methodArgumentNotValidException.getMessage());
        return BaseResponseUtil.fail(methodArgumentNotValidException.getBindingResult().getFieldErrors().stream().map((fieldError) -> {
            return fieldError.getDefaultMessage();
        }).collect(Collectors.joining(",")));
    }

    /**
     * 系统业务异常处理
     *
     * @param serviceException 自定义业务异常
     * @return 响应实体
     */
    @ExceptionHandler(ServiceException.class)
    public BaseResponse<String> handleServiceException(ServiceException serviceException) {
        log.error("发生业务异常，异常信息：{}", serviceException.getMessage());
        return BaseResponseUtil.fail(serviceException.getMessage());
    }

    /**
     * 系统异常处理
     *
     * @param exception 系统异常
     * @return 响应实体
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse<String> handleException(Exception exception) {
        log.error("发生系统异常，异常信息：{}", exception.getMessage());
        return BaseResponseUtil.fail("系统出错啦");
    }
}