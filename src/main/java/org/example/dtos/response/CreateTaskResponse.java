package org.example.dtos.response;

import lombok.Data;

@Data
public class CreateTaskResponse {
    private String id;
    private String message;
    private String dueDate;
}
