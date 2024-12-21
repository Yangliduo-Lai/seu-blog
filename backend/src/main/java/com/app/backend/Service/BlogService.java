package com.app.backend.Service;

import com.app.backend.entity.Blog;
import com.app.backend.entity.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    // 新增文章
    void add(Blog blog);

    // 条件分页列表查询
    PageBean<Blog> list(Integer pageNum, Integer pageSize, Integer tagId, String status);
}
