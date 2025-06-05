package com.gaming.algolabyrinth.controller;

import com.gaming.algolabyrinth.dto.RoomResponseDTO;
import com.gaming.algolabyrinth.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired private RoomService roomService;

    @GetMapping("/{level}")
    public RoomResponseDTO getRoom(@PathVariable int level) {
        return roomService.getRoomByLevel(level);
    }
}
