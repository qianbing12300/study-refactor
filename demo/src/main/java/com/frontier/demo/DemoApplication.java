package com.frontier.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 * @author 纪云行
 */
@MapperScan("com.frontier.demo.mapper")
@SpringBootApplication
public class DemoApplication {
    /**
     * 入口方法
     * @param args 参数数组
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
