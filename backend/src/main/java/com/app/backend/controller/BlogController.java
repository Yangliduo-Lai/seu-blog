package com.app.backend.controller;

import com.app.backend.Service.BlogService;
import com.app.backend.entity.Blog;
import com.app.backend.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/save")
    public Result add(@RequestBody Blog blog) {
        blogService.add(blog);
        return Result.success();
    }
}
