package com.frontier.demo.pojo.domain;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * 用户领域对象
 * @author 纪云行
 */
@Data
public class UserDO {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 生日
     */
    private LocalDateTime birthday;
}