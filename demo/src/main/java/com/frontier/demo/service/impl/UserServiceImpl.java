package com.frontier.demo.service.impl;

import com.frontier.demo.common.OperateEnum;
import com.frontier.demo.pojo.request.QueryUserRequest;
import com.frontier.demo.pojo.request.SaveUserRequest;
import com.frontier.demo.mapper.UserMapper;
import com.frontier.demo.pojo.domain.UserDO;
import com.frontier.demo.pojo.param.QueryUserParam;
import com.frontier.demo.pojo.param.SaveUserParam;
import com.frontier.demo.service.UserService;
import com.frontier.demo.service.constant.NumberConstant;
import com.frontier.demo.pojo.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户服务实现类
 *
 * @author 纪云行
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 用户持久对象
     */
    @Resource
    private UserMapper userMapper;

    @Override
    public OperateEnum saveUser(SaveUserRequest saveUserRequest) {
        SaveUserParam saveUserParam = new SaveUserParam();
        BeanUtils.copyProperties(saveUserRequest, saveUserParam);
        return userMapper.saveUser(saveUserParam) == NumberConstant.ONE ? OperateEnum.ADD_SUCCESS : null;
    }

    @Override
    public UserDTO getUser(int id) {
        UserDTO userDTO = new UserDTO();
        UserDO userDO = userMapper.getUser(id);
        if (Objects.isNull(userDO)) {
            return userDTO;
        }
        BeanUtils.copyProperties(userDO, userDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> listUsers(QueryUserRequest queryUserRequest) {
        QueryUserParam queryUserParam = new QueryUserParam();
        queryUserParam.setName(queryUserRequest.getName());
        return userMapper.listUsers(queryUserParam).stream().map((userDO) -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userDO, userDTO);
            return userDTO;
        }).collect(Collectors.toList());
    }
}