package com.gaming.algolabyrinth.dto;

import java.util.List;

public class UserProgressDTO {
    private String username;
    private int currentLevel;
    private List<Integer> completedRooms;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public List<Integer> getCompletedRooms() {
        return completedRooms;
    }

    public void setCompletedRooms(List<Integer> completedRooms) {
        this.completedRooms = completedRooms;
    }
}
