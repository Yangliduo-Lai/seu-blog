package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    public enum Status { pending, approved, rejected }

    private Integer commentid;
    private Integer articleId;
    private Integer userid;
    private String content;
    private Integer parentid;
    private Status status;
    private LocalDateTime created_time;
}
