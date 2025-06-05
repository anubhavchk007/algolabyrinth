package com.gaming.algolabyrinth.repository;

import com.gaming.algolabyrinth.model.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubmissionRepository extends MongoRepository<Submission, String> {
    List<Submission> findByUserIdAndRoomId(String userId, String roomId);
}
