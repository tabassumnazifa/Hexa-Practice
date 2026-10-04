package com.taskmanager.adapter.in;

import com.taskmanager.application.TaskService;
import com.taskmanager.domain.Task;
import com.taskmanager.ports.out.TaskRepository;
import com.taskmanager.adapter.out.InMemoryTaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is our Driving Adapter. It translates HTTP requests into Use Case calls.
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // We wire the Core (TaskService) and the Adapter (InMemoryTaskRepository) together here
    public TaskController() {
        TaskRepository repository = new InMemoryTaskRepository();
        this.taskService = new TaskService(repository);
    }

    // We use @GetMapping("/create") so you can easily test it in your browser URL bar.
    @GetMapping("/create")
    public Task createTask(@RequestParam String title) {
        // Call the In Port (Use Case)
        return taskService.execute(title);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}