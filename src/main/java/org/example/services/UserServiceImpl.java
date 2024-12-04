package org.example.services;

import org.example.data.model.ToDo;
import org.example.data.model.User;
import org.example.data.repository.ToDoRep;
import org.example.data.repository.UserRep;
import org.example.dtos.request.*;
import org.example.dtos.response.*;
import org.example.exception.*;
import org.example.exception.UserNameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.utils.Mapper.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRep userRep;
    @Autowired
    private ToDoService toDoService;


    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        alreadyExistingUser(registerUserRequest.getUsername().toLowerCase());
        User user= new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setName(registerUserRequest.getName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        User saveUser =userRep.save(user);

        return registerResponseMap(saveUser);
    }

    @Override
    public LoginResponse login(LoginRequest loginUserRequest) {
        User user = userRep.findByUsername(loginUserRequest.getUserName().toLowerCase());
        if (user == null ) {
            throw new InvalidInputEnteredException("User not found");
        }
        if(!user.getUsername().equals(loginUserRequest.getUserName().toLowerCase())) throw new UserDoseNotExist("user not found");
        if(!user.getPassword().equals(loginUserRequest.getPassword())){ throw new InvalidPasswordInputException("wrong password");}
        user.setLogin(true);
        userRep.save(user);
        LoginResponse response = new LoginResponse();
        response.setId(user.getId());
        response.setMessage("Successfully Logged in");

        return response;
    }

    @Override
    public LogoutUserResponse logout(LogoutRequest logoutUserRequest) {
        User user = userRep.findByUsername(logoutUserRequest.getUserName().toLowerCase());
        user.setUsername(logoutUserRequest.getUserName().toLowerCase());
        user.setLogin(false);
        User saved =userRep.save(user);

        return mapLogoutResponse(saved);
    }

    private void alreadyExistingUser(String username) {
        userRep.findAll().forEach(user -> {if (user.getUsername().equals(username.toLowerCase()))
            throw new UserNameAlreadyExistException("Already existing user...");
        });
    }




    @Override
    public UpdateResponse update(UpdateUserRequest updateUserRequest) {
        User user = userRep.findByUsername(updateUserRequest.getUserName().toLowerCase());

        user.setUsername(updateUserRequest.getNewUserName().toLowerCase());
        user.setPassword(updateUserRequest.getNewPassword());
        userRep.save(user);

        UpdateResponse updateResponse = new UpdateResponse();
        updateResponse.setMessage("UPDATE SUCCESSFUL");


        return updateResponse;
    }

    @Override
    public DeleteResponse delete(DeleteUserRequest deleteUserRequest) {
        User user = findByUsername(deleteUserRequest.getUserName().toLowerCase());
        if(!user.getUsername().equals(deleteUserRequest.getUserName().toLowerCase())) throw new UserDoseNotExist("user not found");
        user.setUsername(deleteUserRequest.getUserName().toLowerCase());
        userRep.delete(user);
        DeleteUserRequest deleteUserRequest1 = new DeleteUserRequest();
        user.setUsername(deleteUserRequest1.getUserName());

        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("YOU NO LONGER HAVE ACCESS TO THIS APP");
        return deleteResponse;
    }

    @Override
    public List<ToDo> getUserTask(String username) {
        User user = findByUsername(username);
        user.setUsername(username);
        userRep.save(user);
        return toDoService.getAllTodos();
    }



    private User findByUsername(String username) {
        User user = userRep.findByUsername(username);
        if(user == null)throw new UserDoseNotExist("User Doesn't Exist");
        return user;
    }
}
