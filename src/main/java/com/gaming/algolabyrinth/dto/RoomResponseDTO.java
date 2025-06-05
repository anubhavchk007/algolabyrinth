package com.gaming.algolabyrinth.dto;

import java.util.List;

public class RoomResponseDTO {
    private int level;
    private String title;
    private String description;
    private List<String> sampleInputs;
    private List<String> constraints;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSampleInputs() {
        return sampleInputs;
    }

    public void setSampleInputs(List<String> sampleInputs) {
        this.sampleInputs = sampleInputs;
    }

    public List<String> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }
}
