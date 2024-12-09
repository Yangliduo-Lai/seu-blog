package com.app.backend.entity;

import java.time.LocalDateTime;

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
