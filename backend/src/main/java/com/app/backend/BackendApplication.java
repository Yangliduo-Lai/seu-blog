package com.app.backend;

import com.app.backend.Service.BlogService;
import com.app.backend.entity.Blog;
import jakarta.el.BeanNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class BackendApplication {

    private final BlogService blogService;

    public BackendApplication(BlogService blogService) {
        this.blogService = blogService;
    }
    public static void main(String[] args) {
        // 正确启动 Spring 应用并获取上下文
        ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
        // 从上下文中获取 BackendApplication 实例
        BackendApplication app = context.getBean(BackendApplication.class);

        Blog blog = new Blog();
        blog.setTitle("My second Blog");
        blog.setAuthor("John Doe");
        blog.setContent("This is my second blog post.");
        blog.setCreatedDate(new Date(  System.currentTimeMillis()));
        blog.setUpdatedDate(new Date(   System.currentTimeMillis()));

        // 插入到数据库
        app.blogService.createBlog(blog);  // 通过实例访问 blogService
        System.out.println("Blog entry created: " + blog);
        System.out.println(blog);
    }
}

