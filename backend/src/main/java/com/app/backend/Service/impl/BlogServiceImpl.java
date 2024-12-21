package com.app.backend.Service.impl;

import com.app.backend.Service.BlogService;
import com.app.backend.entity.Blog;
import com.app.backend.entity.PageBean;
import com.app.backend.mapper.BlogMapper;
import com.app.backend.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public PageBean<Blog> list(Integer pageNum, Integer pageSize, Integer tagId, String status) {
        //1. 创建PageBean对象
        PageBean<Blog> pb = new PageBean<>();

        //2. 开启分页查询PageHelper
        PageHelper.startPage(pageNum,pageSize);

        //3. 调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Blog> bs = blogMapper.list(userId,tagId,status);
        // Page 中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Blog> p = (Page<Blog>) bs;

        // 把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}