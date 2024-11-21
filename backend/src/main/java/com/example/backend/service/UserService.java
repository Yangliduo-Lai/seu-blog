package com.example.backend.service;

import com.example.backend.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll(User User);
    public int insert(User User);
    public int update(User User);
    public int delete(User User);
}
