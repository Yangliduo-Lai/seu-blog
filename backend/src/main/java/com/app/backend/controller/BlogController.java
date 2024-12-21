package com.app.backend.controller;

import com.app.backend.Service.BlogService;
import com.app.backend.entity.Blog;
import com.app.backend.entity.PageBean;
import com.app.backend.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/save")
    public Result add(@RequestBody @Validated Blog blog) {
        blogService.add(blog);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageBean<Blog>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer tagId,
            @RequestParam(required = false) String status
    ) {
        PageBean<Blog> pb = blogService.list(pageNum,pageSize,tagId,status);
        return Result.success(pb);
    }
}
