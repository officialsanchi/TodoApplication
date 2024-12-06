package org.example.controller;

import org.example.data.model.ToDo;
import org.example.dtos.request.CreateTaskRequest;
import org.example.dtos.request.DeleteTaskRequest;
import org.example.dtos.request.DeleteUserRequest;
import org.example.dtos.response.APIResponse;
import org.example.dtos.response.CreateTaskResponse;
import org.example.dtos.response.DeleteTaskResponse;
import org.example.exception.ToDoException;
import org.example.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/createTask")
    public ResponseEntity<?> createTask(@RequestBody CreateTaskRequest createTaskResponse) {
        try {
            CreateTaskResponse response = toDoService.createTodo(createTaskResponse);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ToDoException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteTask")
    public ResponseEntity<?> deleteTask(@RequestBody DeleteTaskRequest request) {
        try {
            DeleteTaskResponse response = toDoService.deleteTodo(request);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ToDoException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos() {
        List<ToDo> todos = todoService.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

}
