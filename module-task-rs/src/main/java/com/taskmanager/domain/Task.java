package com.taskmanager.domain;

import java.util.UUID;

public class Task {

    private final String id;
    private String title;
    private boolean isCompleted;

    // Business Rule: A new task is created with a random ID and is not completed
    public Task(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.isCompleted = false;
    }

    // Business Rule: A task can be marked as completed
    public void complete() {
        if (this.isCompleted) {
            throw new IllegalStateException("This task is already completed!");
        }
        this.isCompleted = true;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return isCompleted; }
}