package com.frontier.demo.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页对象
 *
 * @param <T> 数据对象
 * @author 纪云行
 */
@Data
@Accessors(chain = true)
public class Page<T> {
    /**
     * 分页页面索引
     */
    private Integer pageIndex;
    /**
     * 分页页面记录数
     */
    private Integer pageCount;
    /**
     * 分页请求对象参数
     */
    private T request;
}