package org.example.dtos.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskRequest {
    private String id;
    private String title;
    private String description;
    private Date dueDate;
    private boolean completed;
    private String userId;
}
