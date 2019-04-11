package com.example.boot.controller;

import com.example.boot.domain.UserEntity;
import com.example.boot.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTestB {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void testListUsers() throws Exception {
        UserEntity user = new UserEntity(1L, "Lea");
        // 使用Mockito模拟出来一个构造的对象
        // when当依赖的某个方法被调用，then然后返回回来一个值，从而达到一个模拟的效果
        Mockito.when(userService.list()).thenReturn(Collections.singletonList(user));

        mvc.perform(get("/users"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Lea")));
    }
}
