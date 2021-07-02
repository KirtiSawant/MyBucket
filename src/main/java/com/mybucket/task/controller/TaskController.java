package com.mybucket.task.controller;

import com.mybucket.task.model.Task;
import com.mybucket.task.repo.TaskRepository;
import com.mybucket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;
    @PostMapping("/tasks")
    public Task addTask( @RequestBody Task task) {
        return taskRepository.saveTask(task);
    }




}
