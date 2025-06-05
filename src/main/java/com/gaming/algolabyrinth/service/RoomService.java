package com.gaming.algolabyrinth.service;

import com.gaming.algolabyrinth.dto.RoomResponseDTO;
import com.gaming.algolabyrinth.model.Room;
import com.gaming.algolabyrinth.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired private RoomRepository roomRepository;

    public RoomResponseDTO getRoomByLevel(int level) {
        Optional<Room> roomOpt = roomRepository.findByLevel(level);
        if (roomOpt.isEmpty()) return null;

        Room room = roomOpt.get();
        RoomResponseDTO dto = new RoomResponseDTO();
        dto.setLevel(room.getLevel());
        dto.setTitle(room.getTitle());
        dto.setDescription(room.getDescription());
        dto.setSampleInputs(room.getInputCases().subList(0, Math.min(2, room.getInputCases().size())));
        dto.setConstraints(room.getForbiddenKeywords());

        return dto;
    }

    public Room getRoomEntityByLevel(int level) {
        return roomRepository.findByLevel(level).orElse(null);
    }
}
