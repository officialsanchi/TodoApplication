package org.example.services;

import org.example.data.model.ToDo;
import org.example.dtos.request.*;
import org.example.dtos.response.*;

import java.util.List;

public interface UserService {
    RegisterUserResponse register (RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginRequest loginUserRequest);
    LogoutUserResponse logout(LogoutRequest logoutUserRequest);
    UpdateResponse update(UpdateUserRequest updateUserRequest);
    DeleteResponse delete(DeleteUserRequest deleteUserRequest);
//    List<ToDo> getUserTask(String username);
}
