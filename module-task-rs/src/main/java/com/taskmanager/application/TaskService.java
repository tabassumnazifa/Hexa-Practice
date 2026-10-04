package com.taskmanager.application;

import com.taskmanager.domain.Task;
import com.taskmanager.ports.in.CreateTaskUseCase;
import com.taskmanager.ports.out.TaskRepository;
import java.util.List; // We added this import for the List

public class TaskService implements CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task execute(String title) {
        Task newTask = new Task(title);
        taskRepository.save(newTask);
        return newTask;
    }

    // We added this new method to fulfill the interface contract
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}