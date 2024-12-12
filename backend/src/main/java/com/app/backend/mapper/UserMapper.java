package com.app.backend.mapper;

import com.app.backend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    // 用户信息更新
    @Update("update user set nickname=#{nickname},email=#{email},updatedTime=#{updatedTime},signature=#{signature} where userId = #{userid}")
    void infoUpdate(User user);

    // 用户头像更新
    @Update("update user set avatar=#{avatarUrl},updatedTime=now() where userId = #{userid}")
    void updateAvatar(String avatarUrl,Integer userid);

    // 密码更新
    @Update("update user set password=#{password},updatedTime=now() where userId = #{userid}")
    void updatePwd(String password,Integer userid);
}
