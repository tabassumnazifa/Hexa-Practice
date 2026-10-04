package com.taskmanager.ports.in;

import com.taskmanager.domain.Task;
import java.util.List; // We added this import because we are returning a List now

public interface CreateTaskUseCase {

    // Method to create a new task
    Task execute(String title);

    // Method to get all tasks (This is the new part!)
    List<Task> getAllTasks();
}