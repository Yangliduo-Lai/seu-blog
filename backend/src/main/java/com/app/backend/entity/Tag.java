package com.app.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Tag {
    @NotNull(groups = Update.class)
    private Integer tagId;
    @NotEmpty(groups = {Add.class, Update.class})
    private String tagName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;
    private Integer blogId;
    private Integer userId;

    public interface Add{

    }

    public interface Update{

    }
}
