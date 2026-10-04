package com.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        // This line starts the Spring Boot server
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}