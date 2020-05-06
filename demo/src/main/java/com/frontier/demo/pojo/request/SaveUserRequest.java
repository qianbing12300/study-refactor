package com.frontier.demo.pojo.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 新增用户请求实体
 *
 * @author 纪云行
 */
@Data
public class SaveUserRequest {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String name;
    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Integer sex;
    /**
     * 生日
     */
    @NotNull(message = "生日不能为空")
    private LocalDateTime birthday;
}