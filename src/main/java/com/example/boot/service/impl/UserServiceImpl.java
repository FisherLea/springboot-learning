package com.example.boot.service.impl;

import com.example.boot.domain.UserEntity;
import com.example.boot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserEntity> list() {
        List<UserEntity> list = Arrays.asList(new UserEntity(1l, "Lea"),
                new UserEntity(2L, "Jack"));
        return list;
    }
}
