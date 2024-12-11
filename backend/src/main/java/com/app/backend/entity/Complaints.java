package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Complaints {
    public enum Status { pending, resolved}

    private Integer complaintsid;
    private Integer userid;
    private Integer articleid;
    private String content;
    private Status status;
    private LocalDateTime created_time;
}
