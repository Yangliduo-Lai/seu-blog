package com.example.backend.service.impl;

import com.example.backend.dao.UserDao;
import com.example.backend.entity.User;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * 实现UserDetailsService接口，提供自定义的用户详情服务
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // 注入userDao，用于访问用户数据 @Resource
    @Resource
    private UserDao userDao;

    /**
     * 根据用户名加载用户信息 *
     * @param username 用户名
     * @return UserDetails对象，包含用户信息
     * @throws UsernameNotFoundException 如果用户不存在
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过UserDao根据用户名查询用户信息
        User user = userDao.findByUsername(new User().setUsername(username)); // 如果用户不存在，抛出异常
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // 返回UserDetails对象，包含用户名、密码和权限列表(此处简化为返回空列表)
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
