package com.app.backend.mapper;

import com.app.backend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface UserMapper {

    // 根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    // 添加
    @Insert("insert into user(username,userpassword)" +
            " values(#{username},#{userpassword}) ")
    void add(String username, String userpassword);
}
