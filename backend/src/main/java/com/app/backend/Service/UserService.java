package com.app.backend.Service;

import com.app.backend.entity.User;

public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册
    void register(String username, String password);

    // 用户信息更新
    void infoUpdate(User user);

    // 用户头像更新
    void updateAvatar(String avatarUrl);

    // 密码更新
    void updatePwd(String password);
}
