package com.app.backend.entity;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class Complaints {
    public enum Status { pending, resolved }

    @Id
    private Integer complaintId;
    private String complaintTitle;
    private String userId;
    private String complaintContent;
    private Status status;
    private LocalDateTime complaintDate;
}
