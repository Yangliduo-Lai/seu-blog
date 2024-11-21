package com.example.backend.service.impl;

import com.example.backend.dao.userDao;
import com.example.backend.entity.user;
import com.example.backend.service.userService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //启动事物管理
@Scope("prototype") //多例
public class userServiceImpl implements userService {
    @Resource
    private userDao UserDao;

    @Override
    public List<user> findAll(user User) {
        return this.UserDao.findAll(User);
    }

    @Override
    public int insert(user User) {
        return this.UserDao.insert(User);
    }

    @Override
    public int update(user User) {
        return this.UserDao.update(User);
    }

    @Override
    public int delete(user User) {
        return this.UserDao.delete(User);
    }
}
