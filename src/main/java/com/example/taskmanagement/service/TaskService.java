package com.example.taskmanagement.service;

import com.example.taskmanagement.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getTaskBasedUserId(Long userId);
    Task getTask(Long taskId);
    Task updateTask(Task task);
    void deleteTask(Long taskId);
}

