package com.app.backend.entity;

import java.time.LocalDateTime;

public class System_log {
    public enum Target_type { article, user, comment }

    private Integer logid;
    private Integer adminid;
    private String action;
    private Target_type target_type;
    private Integer target_id;
    private LocalDateTime created_time;
}