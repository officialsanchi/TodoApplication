package org.example.dtos.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CreateTaskRequest {
    private String id;
    private String title;
    private String description;
    private LocalDate localDate;
    private boolean completed;
    private String userId;
}
