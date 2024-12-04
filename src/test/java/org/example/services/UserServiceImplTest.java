package org.example.services;

import org.example.data.repository.UserRep;
import org.example.dtos.request.RegisterUserRequest;
import org.example.dtos.response.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserRep userRep;
    @Autowired
    private UserService userService;


    @Test
    public void register() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        RegisterUserResponse response =userService.register(registerUserRequest);
        assertNotNull(response);
    }

    @Test
    void login() {
    }

    @Test
    void logout() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}