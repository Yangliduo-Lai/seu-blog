package com.example.backend.dao;

import com.example.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {
    public List<User> findAll(User user);
    public User findByUsername (User user);
    public int insert(User user);
    public int update(User user);
    public int delete(User user);
}
