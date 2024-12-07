package com.app.backend.entity;

import java.util.ArrayList;
import java.util.Date;  // 导入 Date 类
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * 博客实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Blog")  // 为 MyBatis 指定别名
public class Blog {
    @blogId
    private Long blogId; // 博客 ID
    private String title; // 博客标题
    private String content; // 博客内容
    private String author; // 作者
    private String category; // 分类
    private Integer views; // 浏览量
    private boolean isPublished; // 是否已发布
    private Date createdDate; // 创建日期
    private Date updatedDate; // 更新日期
    private Type type; // 博客类型
    private List<Tag>  tags = new ArrayList<Tag>();
    private List<Comment> comments = new ArrayList<Comment>();
}
