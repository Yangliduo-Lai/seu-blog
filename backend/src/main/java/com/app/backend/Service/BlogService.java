package com.app.backend.Service;

import com.app.backend.entity.Blog;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    // 新增文章
    void add(Blog blog);
}
