package com.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;  // 导入 Date 类

import java.util.Date;
import java.util.List;

/**
 * 博客实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("comment")  // 为 MyBatis 指定别名

public class Comment {
    public enum Status { pending, approved, rejected }

    @Id
    private Integer commentId;
    private Integer blogId;
    private Integer userId;
    private String content;
    private Integer parentId;
    private Status status;
    private LocalDateTime createdTime;
}
