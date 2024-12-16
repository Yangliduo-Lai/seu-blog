package com.app.backend.Service.impl;

import com.app.backend.Service.BlogService;
import com.app.backend.entity.Blog;
import com.app.backend.mapper.BlogMapper;
import com.app.backend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public void add(Blog blog) {
        blog.setCreatedTime(LocalDateTime.now());
        blog.setUpdatedTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        blog.setAuthorId(userId);

        blogMapper.add(blog);
    }
}