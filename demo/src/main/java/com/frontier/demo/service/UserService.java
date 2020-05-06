package com.frontier.demo.service;

import com.frontier.demo.common.OperateEnum;
import com.frontier.demo.pojo.request.QueryUserRequest;
import com.frontier.demo.pojo.request.SaveUserRequest;
import com.frontier.demo.pojo.dto.UserDTO;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author 纪云行
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param saveUserRequest 用户请求实体
     * @return 新增成功或失败
     */
    OperateEnum saveUser(SaveUserRequest saveUserRequest);

    /**
     * 根据用户编号查询用户信息
     *
     * @param id 用户编号
     * @return 用户实体
     */
    UserDTO getUser(int id);

    /**
     * 查询用户集合
     *
     * @param queryUserRequest 查询用户请求实体
     * @return 用户集合
     */
    List<UserDTO> listUsers(QueryUserRequest queryUserRequest);
}