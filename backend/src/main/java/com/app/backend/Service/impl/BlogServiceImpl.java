package com.app.backend.Service.impl;

import com.app.backend.Service.BlogService;
import com.app.backend.entity.Blog;
import com.app.backend.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public void createBlog(Blog blog) {
        blogMapper.insert(blog);
    }

}
