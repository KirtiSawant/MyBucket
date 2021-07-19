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




    @GetMapping("tasks/status")
    public ResponseEntity<List<Task>> searchStatus(
            @RequestParam (defaultValue = "false")String status,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "tId") String[] sortby)
    {
        List<Task> list = taskService.searchStatus(pageNo, pageSize, sortby,status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("tasks/project")
    public ResponseEntity<List<Task>> searchProject(
            @RequestParam (defaultValue = "false")String project,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "tId") String[] sort)
    {
        List<Task> list = taskService.searchProject(pageNo, pageSize, sort,project);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("tasks/priority")
    public ResponseEntity<List<Task>> searchPriority(
            @RequestParam (defaultValue = "false")String priority,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "tId") String[] sort)
    {
        List<Task> list = taskService.searchPriority(pageNo, pageSize, sort,priority);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    }

