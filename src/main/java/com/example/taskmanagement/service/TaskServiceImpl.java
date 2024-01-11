package com.example.taskmanagement.service;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.UserEntity;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserEntityRepository userRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTaskBasedUserId(Long userId) {
       Optional<UserEntity> user = userRepository.findById(userId);
       if(user.isPresent()){
           if(!user.get().getUsername().equalsIgnoreCase("admin")){
               return taskRepository.findByUserId(userId);
           }
           return taskRepository.findAll();
       }
       throw new RuntimeException("Invalid User Id");
    }

    @Override
    public Task getTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()){
            return task.get();
        }
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}

