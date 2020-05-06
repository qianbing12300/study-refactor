package com.frontier.demo.pojo.param;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体参数
 *
 * @author 纪云行
 */
@Data
public class SaveUserParam {
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
    private String sex;
    /**
     * 生日
     */
    private LocalDateTime birthday;
}