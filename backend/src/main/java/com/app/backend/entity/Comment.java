package com.app.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

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
    @commentId
    private Long commentId;
    private String nickname;
    private String content;
    private String avatar;
    private Date createTime;
    private Blog blog;

    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
}
