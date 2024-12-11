package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Tag {
    private Integer tagId;
    private String tagName;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Integer blogId;
    private Integer userId;
}
