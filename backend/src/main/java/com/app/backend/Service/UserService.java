package com.app.backend.Service;

import com.app.backend.entity.User;

public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册
    void register(String username, String password);

    // 返回用户类型
    String getRole(String username);
}
