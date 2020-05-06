package com.frontier.demo.advice;

import com.frontier.demo.common.OperateEnum;
import com.frontier.demo.util.BaseResponseUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.frontier.demo.common.BaseResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义全局包装处理器
 *
 * @author 纪云行
 */
@Slf4j
@ControllerAdvice
public class CustomWrapHandler<T> implements ResponseBodyAdvice<T> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType,
        Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
        ServerHttpResponse response) {
        // 系统发生异常执行 校验异常、自定义异常、系统异常
        if (body.getClass().equals(BaseResponse.class)) {
            return body;
        }
        // 写操作成功执行
        if (body.getClass().equals(OperateEnum.class)) {
            return (T) BaseResponseUtil.success((OperateEnum)body);
        }
        // 读操作成功执行
        return (T) BaseResponseUtil.success(body);
    }
}