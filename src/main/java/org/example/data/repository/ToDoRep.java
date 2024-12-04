package org.example.data.repository;

import org.example.data.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRep extends MongoRepository<ToDo,String> {
}
