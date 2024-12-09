package com.app.backend.entity;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class SystemLog {
    public enum LogType { article, user, comment }

    @Id
    private Integer logId;
    private Integer adminId;
    private String action;
    private LogType logType;
    private Integer targetId; // 操作对象ID
    private LocalDateTime createdTime;
}
