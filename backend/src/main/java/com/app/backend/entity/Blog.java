package com.app.backend.entity;

import java.time.LocalDateTime;

public class Blog {
    public enum Status { draft, published, deleted };

    private Integer blogId;
    private String title;
    private String content;
    private String tags;
    private String category;
    private Status status;
    private Integer author;
    private LocalDateTime created_time;
    private LocalDateTime updated_time;
}
