package com.gaming.algolabyrinth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
public class User {
    @Id
    private String id;
    private String username;
    private int currentRoom;
    private List<String> completedRooms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<String> getCompletedRooms() {
        return completedRooms;
    }

    public void setCompletedRooms(List<String> completedRooms) {
        this.completedRooms = completedRooms;
    }
}
