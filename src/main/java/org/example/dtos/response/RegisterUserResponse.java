package org.example.dtos.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String Id;

    private String email;
    private String dateRegistered;

}
