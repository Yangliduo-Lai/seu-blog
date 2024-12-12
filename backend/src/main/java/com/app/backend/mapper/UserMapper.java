package com.app.backend.mapper;

import com.app.backend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    // 根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user(username,password,createdTime,updatedTime)" +
            " values(#{username},#{password},now(),now()) ")
    void add(String username, String password);

    // 根据用户名查询用户类型
    @Select("select role from user where username=#{username}")
    String findRoleByUsername(String username);
}
