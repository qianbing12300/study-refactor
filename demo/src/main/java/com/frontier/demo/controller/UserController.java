package com.frontier.demo.controller;

import com.frontier.demo.common.OperateEnum;
import com.frontier.demo.pojo.request.QueryUserRequest;
import com.frontier.demo.pojo.request.SaveUserRequest;
import com.frontier.demo.service.UserService;
import com.frontier.demo.pojo.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户控制类
 *
 * @author 纪云行
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 用户服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 新增用户
     *
     * @param saveUserRequest 新增用户请求参数
     * @return 新增成功或失败
     */
    @PostMapping("saveUser")
    public OperateEnum saveUser(@Valid  @RequestBody SaveUserRequest saveUserRequest) {
        return userService.saveUser(saveUserRequest);
    }

    /**
     * 查询单个用户
     *
     * @param id 用户编号
     * @return 用户实体
     */
    @GetMapping("queryUser")
    public UserDTO queryUser(@RequestParam int id) {
        return userService.getUser(id);
    }

    /**
     * 查询用户集合
     *
     * @param queryUserRequest 查询用户请求
     * @return 用户集合
     */
    @PostMapping("queryUserList")
    public List<UserDTO> queryUserList(@RequestBody QueryUserRequest queryUserRequest) {
        return userService.listUsers(queryUserRequest);
    }
}