package org.example.dtos.request;

import lombok.Data;

@Data
public class DeleteUserRequest {
    private String message;
    private String userName;
}
