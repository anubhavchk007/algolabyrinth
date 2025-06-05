package com.gaming.algolabyrinth.repository;

import com.gaming.algolabyrinth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
