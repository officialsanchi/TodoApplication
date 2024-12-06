package org.example.services;

import org.example.data.model.ToDo;
import org.example.data.repository.ToDoRep;
import org.example.dtos.request.CreateTaskRequest;
import org.example.dtos.request.EditTaskRequest;
import org.example.dtos.response.CreateTaskResponse;
import org.example.dtos.response.EditTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ToDoServiceImplTest {
    @Autowired
    private ToDoRep toDoRep;
    @Autowired
    private ToDoService toDoService;
    @BeforeEach
    public void setUp(){
        toDoRep.deleteAll();
    }

    @Test
    public void testToCreateATask(){
        CreateTaskRequest toDo = new CreateTaskRequest();
        toDo.setTitle("Java");
        toDo.setDescription("i need to complete my task");
        toDo.setLocalDate(LocalDate.of(2024,12,25));
        toDo.setCompleted(false);
        CreateTaskResponse response = toDoService.createTodo(toDo);
        response.setMessage("Successfully Created");
        assertNotNull(response);
        assertEquals(1,toDoService.getTask());
    }
    @Test
    public void testToEditTask(){
        CreateTaskRequest toDo = new CreateTaskRequest();
        toDo.setTitle("Java");
        toDo.setDescription("i need to complete my task");
        toDo.setLocalDate(LocalDate.of(2024,12,25));
        toDo.setCompleted(false);
        toDoService.createTodo(toDo);
        EditTaskRequest request = new EditTaskRequest();
        request.setId(toDo.getId());
        request.setTitle("pyton");
        request.setDescription("hello world");
        request.setCompleted(true);
        EditTaskResponse response =toDoService.editTodo(request);
        response.setMessage("Edit Successfully done");
        assertEquals(1, toDoService.getTask());
    }

}