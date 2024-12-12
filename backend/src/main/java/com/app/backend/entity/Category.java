package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer categoryId;
    private String categoryName;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Integer blogId;
    private Integer userId;
    private Integer parentId;
}
