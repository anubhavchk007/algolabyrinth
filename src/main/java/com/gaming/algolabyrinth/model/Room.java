package com.gaming.algolabyrinth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("rooms")
public class Room {
    @Id
    private String id;
    private int level;
    private String title;
    private String description;
    private List<String> inputCases;
    private List<String> expectedOutputs;
    private List<String> forbiddenKeywords;
    private long timeLimitMs;
    private long memoryLimitKb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<String> getInputCases() {
        return inputCases;
    }

    public void setInputCases(List<String> inputCases) {
        this.inputCases = inputCases;
    }

    public List<String> getExpectedOutputs() {
        return expectedOutputs;
    }

    public void setExpectedOutputs(List<String> expectedOutputs) {
        this.expectedOutputs = expectedOutputs;
    }

    public List<String> getForbiddenKeywords() {
        return forbiddenKeywords;
    }

    public void setForbiddenKeywords(List<String> forbiddenKeywords) {
        this.forbiddenKeywords = forbiddenKeywords;
    }

    public long getTimeLimitMs() {
        return timeLimitMs;
    }

    public void setTimeLimitMs(long timeLimitMs) {
        this.timeLimitMs = timeLimitMs;
    }

    public long getMemoryLimitKb() {
        return memoryLimitKb;
    }

    public void setMemoryLimitKb(long memoryLimitKb) {
        this.memoryLimitKb = memoryLimitKb;
    }
}
