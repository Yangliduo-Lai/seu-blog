package com.app.backend.Service.impl;

import com.app.backend.Service.UserService;
import com.app.backend.entity.User;
import com.app.backend.mapper.UserMapper;
import com.app.backend.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        // 加密
        String md5String = Md5Util.getMD5String(password);

        // 添加
        userMapper.add(username,md5String);
    }
}
