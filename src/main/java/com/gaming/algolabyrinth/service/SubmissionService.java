package com.gaming.algolabyrinth.service;

import com.gaming.algolabyrinth.dto.SubmitSolutionRequestDTO;
import com.gaming.algolabyrinth.dto.SubmitSolutionResponseDTO;
import com.gaming.algolabyrinth.model.Room;
import com.gaming.algolabyrinth.model.Submission;
import com.gaming.algolabyrinth.model.User;
import com.gaming.algolabyrinth.repository.SubmissionRepository;
import com.gaming.algolabyrinth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

@Service
public class SubmissionService {
    @Autowired private RoomService roomService;
    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;
    @Autowired private SubmissionRepository submissionRepository;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    private final ConcurrentHashMap<String, Boolean> userSubmissionLocks = new ConcurrentHashMap<>();

    public SubmitSolutionResponseDTO submitSolution(SubmitSolutionRequestDTO request) throws Exception {
        User user = userService.getOrCreateUser(request.getUserId());
        int level = user.getCurrentRoom();
        String lockKey = user.getUsername() + "_L" + level;

        if (userSubmissionLocks.putIfAbsent(lockKey, true) != null) {
            throw new IllegalStateException("Already processing a submission");
        }

        try {
            Room room = roomService.getRoomEntityByLevel(level);
            Submission submission = new Submission();
            submission.setUserId(user.getId());
            submission.setRoomId(room.getId());
            submission.setCode(request.getCode());
            submission.setLanguage(request.getLanguage());
            submission.setSubmittedAt(Instant.now());

            Future<Boolean> resultFuture = executor.submit(() -> simulateRun(request.getCode(), room));

            boolean passed = resultFuture.get(4, TimeUnit.SECONDS);
            submission.setPassed(passed);
            submission.setExecutionTimeMs(130);
            submission.setResultMessage(passed ? "Success" : "Incorrect Output");

            submissionRepository.save(submission);

            SubmitSolutionResponseDTO response = new SubmitSolutionResponseDTO();
            response.setPassed(passed);
            response.setResultMessage(submission.getResultMessage());
            response.setExecutionTimeMs(submission.getExecutionTimeMs());

            if (passed) {
                user.setCurrentRoom(user.getCurrentRoom() + 1);
                List<String> completed = user.getCompletedRooms();
                completed.add(String.valueOf(level));
                user.setCompletedRooms(completed);
                userRepository.save(user);
                response.setNextLevel(user.getCurrentRoom());
            } else {
                response.setNextLevel(user.getCurrentRoom());
            }

            return response;
        } finally {
            userSubmissionLocks.remove(lockKey);
        }
    }

    private boolean simulateRun(String code, Room room) {
        return !room.getForbiddenKeywords().stream().anyMatch(code::contains);
    }
}
