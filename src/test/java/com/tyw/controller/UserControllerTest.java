package com.tyw.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by tboss on 2017/11/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void findUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1").param("id","1")).andExpect(MockMvcResultMatchers.content().json("{\"username\":\"tboss\",\"password\":\"123456\",\"createTime\":\"2018-08-236 07:03:45\",\"updateTime\":null,\"state\":\"INIT\",\"id\":1}"));
    }

}