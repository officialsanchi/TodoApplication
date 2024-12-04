package org.example.services;

import org.example.data.model.ToDo;
import org.example.data.repository.ToDoRep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        ToDo toDo = new ToDo();
        toDo.setTitle("Java");
        toDo.setDescription("i need to complete my task");
    }

}