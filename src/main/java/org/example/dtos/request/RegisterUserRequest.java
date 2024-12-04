package org.example.dtos.request;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String id;
    private String email;
    private String username;
    private String name;
    private String password;
    private boolean isLocked;
}
