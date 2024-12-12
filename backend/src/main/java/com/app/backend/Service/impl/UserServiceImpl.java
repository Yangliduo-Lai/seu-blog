package com.app.backend.Service.impl;

import com.app.backend.Service.UserService;
import com.app.backend.entity.User;
import com.app.backend.mapper.UserMapper;
import com.app.backend.utils.Md5Util;
import com.app.backend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public String getRole(String username) {
        return userMapper.findRoleByUsername(username);
    }

    @Override
    public void infoUpdate(User user) {
        user.setUpdatedTime(LocalDateTime.now());
        userMapper.infoUpdate(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,userid);
    }

    @Override
    public void updatePwd(String password) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(password), userid);
    }
}
