package org.example.utils;

import org.example.data.model.User;
import org.example.dtos.request.RegisterUserRequest;
import org.example.dtos.response.LoginResponse;
import org.example.dtos.response.LogoutUserResponse;
import org.example.dtos.response.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static RegisterUserResponse registerResponseMap(User user) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(user.getId());
        registerUserResponse.setEmail(user.getEmail());
        registerUserResponse.setDateRegistered(DateTimeFormatter
                .ofPattern("dd/MMM/yyyy 'at' HH:mm:ss a").format(user.getLocalDateTime()));
        return registerUserResponse;

    }
    public static LogoutUserResponse mapLogoutResponse(User user) {
        LogoutUserResponse logoutUserResponse = new LogoutUserResponse();
        logoutUserResponse.setId(user.getId());
        logoutUserResponse.setMessage("Logout successful");
        return logoutUserResponse;

    }

}
