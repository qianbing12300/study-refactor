package com.frontier.demo.pojo.request;

import lombok.Data;

/**
 * 查询用户请求实体
 *
 * @author 纪云行
 */
@Data
public class QueryUserRequest {
    /**
     * 用户名
     */
    private String name;
}
