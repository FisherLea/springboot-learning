package com.example.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.domain.UserEntity;
import com.example.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String getUsers(){
        List<UserEntity> users = userService.list();
        return JSONObject.toJSONString(users);
    }
}
