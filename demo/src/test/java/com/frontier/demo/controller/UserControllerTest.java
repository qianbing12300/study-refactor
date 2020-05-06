package com.frontier.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.Instant;

/**
 * 用户控制器测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    /**
     * 注入应用上下文
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * mockMvc对象
     */
    private MockMvc mockMvc;

    /**
     * 初始化
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 新增用户
     *
     * @throws Exception 异常
     */
    @Test
    public void testSaveUser() throws Exception {
        String content =
                "{\"name\":\"world\",\"age\":18,\"sex\":1,\"birthday\":" + Instant.now().toEpochMilli() + "}";
        String result = mockMvc
                .perform(MockMvcRequestBuilders.post("/user/saveUser").contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                /*.andExpect(MockMvcResultMatchers.status().isOk())*/.andReturn().getResponse().getContentAsString();
        System.out.println("新增用户:" + result);
    }

    /**
     * 查询单个用户
     *
     * @throws Exception 异常
     */
    @Test
    public void testQueryUser() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/queryUser?id=" + 15).contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("查询单个用户:" + result);
    }

    /**
     * 查询用户集合
     *
     * @throws Exception 异常
     */
    @Test
    public void testQueryUserList() throws Exception {
        String content =
                "{\"name\":\"管\"}";
        String result = mockMvc
                .perform(MockMvcRequestBuilders.post("/user/queryUserList").contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("查询用户集合:" + result);
    }
}