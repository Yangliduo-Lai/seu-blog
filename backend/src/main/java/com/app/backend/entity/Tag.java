package com.app.backend.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Tag {
    private Integer tagId;
    @NotEmpty
    private String tagName;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Integer blogId;
    private Integer userId;
}
