package com.gaming.algolabyrinth.controller;

import com.gaming.algolabyrinth.dto.UserProgressDTO;
import com.gaming.algolabyrinth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/{username}/progress")
    public UserProgressDTO getProgress(@PathVariable String username) {
        return userService.getUserProgress(username);
    }
}
