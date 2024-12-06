package org.example.services;

import org.example.data.model.ToDo;
import org.example.data.repository.ToDoRep;
import org.example.dtos.request.CreateTaskRequest;
import org.example.dtos.request.DeleteTaskRequest;
import org.example.dtos.request.EditTaskRequest;
import org.example.dtos.response.CreateTaskResponse;
import org.example.dtos.response.DeleteTaskResponse;
import org.example.dtos.response.EditTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRep toDoRepository;

    @Override
    public CreateTaskResponse createTodo(CreateTaskRequest createTaskRequest) {

        ToDo todo = new ToDo();
        todo.setTitle(createTaskRequest.getTitle());
        todo.setDescription(createTaskRequest.getDescription());
        todo.setLocalDate(createTaskRequest.getLocalDate());
        todo.setCompleted(false);
        ToDo savedTodo = toDoRepository.save(todo);
        CreateTaskResponse taskResponse = new CreateTaskResponse();
        taskResponse.setId(savedTodo.getId());
        taskResponse.setMessage("successfully created a new task");
        return taskResponse;
    }

    @Override
    public EditTaskResponse editTodo(EditTaskRequest editTaskRequest) {
        Optional<ToDo> todoOptional = toDoRepository.findById(editTaskRequest.getId());
        if (todoOptional.isPresent()) {
            ToDo todo = todoOptional.get();
            todo.setTitle(editTaskRequest.getTitle());
            todo.setDescription(editTaskRequest.getDescription());
            todo.setLocalDate(editTaskRequest.getLocalDate());
            todo.setCompleted(true);
            toDoRepository.save(todo);
        }
//            return new EditTaskResponse(true);
//        } else {
//            return new EditTaskResponse(false);
//        }
        return null;

    }

    @Override
    public DeleteTaskResponse deleteTodo(DeleteTaskRequest deleteTaskRequest) {
        toDoRepository.deleteById(deleteTaskRequest.getId());
        DeleteTaskResponse response = new DeleteTaskResponse();
        response.setMessage("Successfully deleted");
        return response;
    }

    @Override
    public List<ToDo> getAllTodos() {
        return toDoRepository.findAll();
    }

    @Override
    public Optional<ToDo> getTodoById(String id) {
        return toDoRepository.findById(id);
    }

    @Override
    public Long getTask() {
        return toDoRepository.count();
    }
}