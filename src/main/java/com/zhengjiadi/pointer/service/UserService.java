package com.zhengjiadi.pointer.service;



import com.zhengjiadi.pointer.utils.BaseJson;


public interface UserService {
    // 注册
    BaseJson register(String phone, String password, String messageCode);

    // 获取验证码
    BaseJson getMessageCode(String phone);

    // 登录
    BaseJson login(String phone, String password);
}
