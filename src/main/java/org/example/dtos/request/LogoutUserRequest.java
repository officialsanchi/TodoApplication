package org.example.dtos.request;

import lombok.Data;

@Data
public class LogoutUserRequest {
    private String id;
    private String userName;
    private String password;
}
