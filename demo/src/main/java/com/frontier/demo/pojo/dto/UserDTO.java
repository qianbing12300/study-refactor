package com.frontier.demo.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体传输对象
 *
 * @author 纪云行
 */
@Data
public class UserDTO {
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
