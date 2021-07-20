package com.mybucket.controller;

import com.mybucket.model.GroupUser;
import com.mybucket.model.Task;
import com.mybucket.model.TaskJoin;
import com.mybucket.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping(value = "tasks")
    public Task addTask(@Valid @RequestBody Task task) {
        return taskService.addTask(task);
    }


    @GetMapping("/task/user/{uid}")
    public List<TaskJoin> getTaskForUser(@PathVariable("uid") int uid) {
        return taskService.getTaskForUser(uid);
    }

    @GetMapping("/task/{tId}")
    public Task getTask(@PathVariable("tId") int tId) {
        return taskService.getTask(tId);
    }

    @PutMapping("task/{tId}")
    public Task updateTask(@PathVariable("tId") int tId, @RequestBody Task task) {
        return taskService.updateTask(tId, task);
    }

    @DeleteMapping("/task/{tId}")
    public String delete(@PathVariable("tId") int tId) {
        return taskService.deleteTask(tId);
    }

    @GetMapping("/taskStatus")
    public List<GroupUser> getEstimatedHours(@RequestParam String status) {
        return taskService.getEstimatedHours(status);
    }




/*
    @GetMapping("tasks/search")
    public ResponseEntity<List<TaskJoin>> search(
            @RequestParam String status,
            @RequestParam  String project,
            @RequestParam String priority,
            @RequestParam String userName,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize)
    {
        List<TaskJoin> list = taskService.search(pageNo, pageSize,status,project,priority,userName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
*/
    @GetMapping("tasks/search")
    public ResponseEntity<List<Task>> search(
            @RequestParam String status,
            @RequestParam  String project,
            @RequestParam String priority,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize)
    {
        List<Task> list = taskService.search(pageNo, pageSize,status,project,priority);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    }

