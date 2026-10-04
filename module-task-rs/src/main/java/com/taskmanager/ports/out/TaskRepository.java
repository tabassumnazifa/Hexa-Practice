package com.taskmanager.ports.out;

import com.taskmanager.domain.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    void save(Task task);
    List<Task> findAll();
    Optional<Task> findById(String id);
}