package com.example.backend.service;

import com.example.backend.entity.user;

import java.util.List;

public interface userService {
    public List<user> findAll(user User);
    public int insert(user User);
    public int update(user User);
    public int delete(user User);
}
