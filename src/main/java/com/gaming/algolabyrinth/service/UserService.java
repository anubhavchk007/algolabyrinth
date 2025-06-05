package com.gaming.algolabyrinth.service;

import com.gaming.algolabyrinth.dto.UserProgressDTO;
import com.gaming.algolabyrinth.model.User;
import com.gaming.algolabyrinth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public User getOrCreateUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setCurrentRoom(1);
            userRepository.save(user);
        }

        return user;
    }

    public UserProgressDTO getUserProgress(String username) {
        User user = getOrCreateUser(username);
        UserProgressDTO dto = new UserProgressDTO();
        dto.setUsername(user.getUsername());
        dto.setCurrentLevel(user.getCurrentRoom());
        dto.setCompletedRooms(
                user.getCompletedRooms()
                        .stream().map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
