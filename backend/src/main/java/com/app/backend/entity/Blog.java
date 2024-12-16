package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Blog {
    public enum Status { draft, published, deleted };

    private Integer blogId;
    private String title;
    private String content;
    private Integer authorId;
    private Integer views;
    private Status status;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Integer categoryId;
}
