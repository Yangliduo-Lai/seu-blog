package com.app.backend.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Blog {
    public enum Status { draft, published, deleted }

    private Integer blogId;
    @NotEmpty
    @Pattern(regexp = "^.{1,20}$")
    private String title;
    @NotEmpty
    private String content;
    private Integer authorId;
    private Integer views;
    private Status status;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Integer tagId;
}
