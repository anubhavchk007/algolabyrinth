package com.gaming.algolabyrinth.repository;

import com.gaming.algolabyrinth.model.Room;
import com.gaming.algolabyrinth.model.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findByLevel(int level);
}
