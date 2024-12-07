package com.app.backend.mapper;

import com.app.backend.entity.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {

    @Insert("INSERT INTO blog (title, content, author, category, views, is_published, created_date, updated_date) " +
            "VALUES (#{title}, #{content}, #{author}, #{category}, #{views}, #{isPublished}, #{createdDate}, #{updatedDate})")
    void insert(Blog blog);
}
