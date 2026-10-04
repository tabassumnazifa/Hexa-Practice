package com.taskmanager.adapter.out;

import com.taskmanager.domain.Task;
import com.taskmanager.ports.out.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTaskRepository implements TaskRepository {

    // Simulating a database table using a Thread-Safe Map
    private final Map<String, Task> database = new ConcurrentHashMap<>();

    // We added this Constructor to pre-load some data when the app starts!
    public InMemoryTaskRepository() {
        Task task1 = new Task("Learn Hexagonal Architecture");
        Task task2 = new Task("Build a cool project with Spring Boot");

        // Save them to our "database"
        save(task1);
        save(task2);
    }

    @Override
    public void save(Task task) {
        database.put(task.getId(), task);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }
}