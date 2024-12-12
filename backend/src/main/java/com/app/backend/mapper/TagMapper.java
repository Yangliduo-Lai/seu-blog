package com.app.backend.mapper;

import com.app.backend.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    // 新增tag
    @Insert("insert into tag(tagName,createdTime,updatedTime,userId)" +
            "values(#{tagName},#{createdTime},#{updatedTime},#{userId})")
    void add(Tag tag);
}
