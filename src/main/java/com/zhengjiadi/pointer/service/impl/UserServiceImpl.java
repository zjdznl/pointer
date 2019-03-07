package com.zhengjiadi.pointer.service.impl;

import com.zhengjiadi.pointer.utils.BaseJson;
import com.zhengjiadi.pointer.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public BaseJson register(String phone, String password, String messageCode) {
        return null;
    }

    @Override
    public BaseJson getMessageCode(String phone) {
        return null;
    }

    @Override
    public BaseJson login(String phone, String password) {
        return null;
    }
}
