package org.example.dtos.request;

import lombok.Data;

@Data
public class UpdateUserRequest{
    private String userName;
    private String password;
    private String newUserName;
    private String newPassword;
}

