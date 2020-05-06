package com.frontier.demo.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据返回实体
 *
 * @author 纪云行
 */
@Data
@Accessors(chain = true)
public final class BaseResponse<T> {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;
}