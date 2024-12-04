package org.example.data.repository;

import org.example.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRep extends MongoRepository<User, String> {
    boolean existsByUsername(String username);

    User findByEmail(String email);

    User findByUsername(String lowerCase);
}
