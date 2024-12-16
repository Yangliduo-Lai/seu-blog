package com.app.backend.mapper;

import com.app.backend.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    // 新增文章
    @Insert("insert into blog(title,content,status,categoryId,authorId,createdTime,updatedTime) " +
            "values(#{title},#{content},#{status},#{categoryId},#{authorId},#{createdTime},#{updatedTime})")
    void add(Blog blog);
}
