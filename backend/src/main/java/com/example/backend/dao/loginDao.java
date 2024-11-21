package com.example.backend.dao;

import com.example.backend.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginDao {
    public user findByUsername (user User);
}
