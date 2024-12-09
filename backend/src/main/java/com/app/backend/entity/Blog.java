package com.app.backend.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;

/**
 * 博客实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Blog")  // 为 MyBatis 指定别名
public class Blog {
    public enum Status { draft, published, deleted }

    @Id
    private Long blogId; // 博客 ID

    private String title; // 博客标题
    private String content; // 博客内容
    private String authorId; // 作者
    private String category; // 分类
    private Integer views; // 浏览量
    private Status status; // 文章状态
    private LocalDateTime createdTime; // 创建时间
    private LocalDateTime updatedTime; // 更新时间
}
