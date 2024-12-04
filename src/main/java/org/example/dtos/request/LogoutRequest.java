package org.example.dtos.request;

import lombok.Data;

@Data
public class LogoutRequest {
    private String email;
    private String userName;
}
