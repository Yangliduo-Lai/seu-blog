package com.app.backend.Service;

import com.app.backend.entity.Blog;
import com.app.backend.mapper.BlogMapper;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    public void createBlog(Blog blog);

}
