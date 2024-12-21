package com.app.backend.mapper;

import com.app.backend.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    // 新增文章
    @Insert("insert into blog(title,concepts,content,status,tagId,authorId,createdTime,updatedTime) " +
            "values(#{title},#{concepts},#{content},#{status},#{tagId},#{authorId},#{createdTime},#{updatedTime})")
    void add(Blog blog);

    // 条件分页查询
    List<Blog> list(Integer userId, Integer tagId, String status);
}
