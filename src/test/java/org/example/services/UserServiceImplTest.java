package org.example.services;

import org.example.data.repository.UserRep;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterUserRequest;
import org.example.dtos.response.LoginResponse;
import org.example.dtos.response.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserRep userRep;
    @Autowired
    private UserService userService;
    @BeforeEach
    public void setUp(){
        userRep.deleteAll();
    }


    @Test
    public void register() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        registerUserRequest.setEmail("ayomide123@gmail.com");
        RegisterUserResponse response =userService.register(registerUserRequest);
        assertNotNull(response);
        assertEquals("user1",registerUserRequest.getUsername());
    }

    @Test
    public void login() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        registerUserRequest.setEmail("ayomide123@gmail.com");
        RegisterUserResponse response =userService.register(registerUserRequest);
        assertNotNull(response);
        assertEquals("user1",registerUserRequest.getUsername());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName("user1");
        loginRequest.setPassword("112233");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertNotNull(loginResponse);

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