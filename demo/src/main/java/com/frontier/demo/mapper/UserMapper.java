package com.frontier.demo.mapper;

import com.frontier.demo.pojo.domain.UserDO;
import com.frontier.demo.pojo.param.QueryUserParam;
import com.frontier.demo.pojo.param.SaveUserParam;

import java.util.List;

/**
 * 用户持久接口
 *
 * @author 纪云行
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param saveUserParam 用户实体
     * @return 新增成功或失败
     */
    int saveUser(SaveUserParam saveUserParam);

    /**
     * 根据用户编号查询用户信息
     *
     * @param id 用户编号
     * @return 用户实体
     */
    UserDO getUser(int id);

    /**
     * 根据查询参数查询用户集合
     *
     * @param queryUserParam 查询参数实体
     * @return 用户集合
     */
    List<UserDO> listUsers(QueryUserParam queryUserParam);
}