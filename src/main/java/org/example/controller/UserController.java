package org.example.controller;

import com.mongodb.internal.bulk.UpdateRequest;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.LogoutRequest;
import org.example.dtos.request.RegisterUserRequest;
import org.example.dtos.request.UpdateUserRequest;
import org.example.dtos.response.*;
import org.example.exception.ToDoException;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
//@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService  userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            RegisterUserResponse response = userService.register(registerUserRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ToDoException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = userService.login(request);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ToDoException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> login(@RequestBody LogoutRequest request) {
        try {
            LogoutUserResponse response = userService.logout(request);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ToDoException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateUserRequest request) {
        try {
            UpdateResponse response = userService.update(request);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ToDoException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
