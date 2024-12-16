package com.app.backend.mapper;

import com.app.backend.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    // 根据id查询
    @Select("select * from tag where tagId = #{id} ")
    Tag findById(Integer id);

    // 更新
    @Update("update tag set tagName=#{tagName},updatedTime=#{updatedTime} where tagId=#{tagId}")
    void update(Tag tag);
}
