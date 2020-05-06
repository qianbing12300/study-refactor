package com.frontier.demo.exception;

/**
 * 自定义业务异常
 *
 * @author 纪云行
 */
public class ServiceException extends RuntimeException {
    /**
     * 构造器
     *
     * @param message 自定义消息
     */
    public ServiceException(String message) {
        super(message);
    }
}