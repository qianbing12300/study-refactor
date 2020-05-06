package com.frontier.demo.util;

import com.frontier.demo.common.BaseResponse;
import com.frontier.demo.common.OperateEnum;

/**
 * 响应包装工具类
 *
 * @author 纪云行
 */
public final class BaseResponseUtil {
    /**
     * 成功编码
     */
    private static final Integer SUCCESS_CODE = 200;
    /**
     * 失败编码
     */
    private static final Integer FAIL_CODE = 500;

    /**
     * 构造器私有，防止外部实例化
     */
    private BaseResponseUtil() {
    }

    /**
     * 包裹响应对象，此方法适合写操作没有数据实体场景下调用
     *
     * @return 响应实体
     */
    public static BaseResponse success(OperateEnum operateEnum) {
        return success().setMessage(operateEnum.getMessage());
    }

    /**
     * 包裹响应对象，此方法适合查询操作有数据实体场景下调用
     *
     * @param data 数据实体
     * @return 响应实体
     */
    public static BaseResponse success(Object data) {
        return success().setMessage(OperateEnum.QUERY_SUCCESS.getMessage()).setData(data);
    }

    /**
     * 包裹响应对象，此方法适合系统发生异常（校验框架异常、自定义业务异常、系统异常）场景下调用
     *
     * @param message 异常消息
     * @return 响应实体
     */
    public static BaseResponse fail(String message) {
        return fail().setMessage(message);
    }

    /**
     * 设置成功标志位
     *
     * @return 响应实体
     */
    private static BaseResponse success() {
        return new BaseResponse().setCode(SUCCESS_CODE);
    }

    /**
     * 设置失败标志位
     *
     * @return 响应实体
     */
    private static BaseResponse fail() {
        return new BaseResponse().setCode(FAIL_CODE);
    }
}