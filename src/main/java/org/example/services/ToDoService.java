package org.example.services;

import org.example.data.model.ToDo;
import org.example.dtos.request.CreateTaskRequest;
import org.example.dtos.request.DeleteTaskRequest;
import org.example.dtos.request.EditTaskRequest;
import org.example.dtos.response.CreateTaskResponse;
import org.example.dtos.response.DeleteTaskResponse;
import org.example.dtos.response.EditTaskResponse;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    CreateTaskResponse createTodo(CreateTaskRequest createTaskRequest);
    EditTaskResponse editTodo(EditTaskRequest editTaskRequest);
    DeleteTaskResponse deleteTodo(DeleteTaskRequest deleteTaskRequest);
    List<ToDo> getAllTodos();
    Optional<ToDo> getTodoById(String id);
    Long getTask();


}
