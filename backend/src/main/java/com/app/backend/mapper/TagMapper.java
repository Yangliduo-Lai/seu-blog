package com.app.backend.mapper;

import com.app.backend.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {
    // 新增tag
    @Insert("insert into tag(tagName,createdTime,updatedTime,userId)" +
            "values(#{tagName},#{createdTime},#{updatedTime},#{userId})")
    void add(Tag tag);

    // 查询所有tag
    @Select("select * from tag where userId=#{userId}")
    List<Tag> list(Integer userId);
}
