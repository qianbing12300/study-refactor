package com.frontier.demo.common;

/**
 * 全局写操作枚举类
 *
 * @author 纪云行
 */
public enum OperateEnum {
    /**
     * 新增成功
     */
    ADD_SUCCESS("新增成功"),
    /**
     * 修改成功
     */
    UPDATE_SUCCESS("修改成功"),
    /**
     * 删除成功
     */
    DELETE_SUCCESS("删除成功"),
    /**
     * 删除成功
     */
    QUERY_SUCCESS("查询成功");
    /**
     * 消息
     */
    private String message;

    /**
     * 默认私有化构造器
     *
     * @param message 消息
     */
    OperateEnum(String message) {
        this.message = message;
    }

    /**
     * 获取写操作自定义消息
     *
     * @return 消息
     */
    public String getMessage() {
        return message;
    }
}