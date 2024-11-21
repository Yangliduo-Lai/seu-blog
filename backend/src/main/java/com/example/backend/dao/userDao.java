package com.example.backend.dao;

import com.example.backend.entity.user;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface userDao {
    public List<user> findAll(user User);
    public int insert(user User);
    public int update(user User);
    public int delete(user User);
}
