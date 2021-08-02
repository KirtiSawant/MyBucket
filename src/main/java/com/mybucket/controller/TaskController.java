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

    @PostMapping(value = "task")
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



    @GetMapping("task/search")
    public ResponseEntity<List<Task>> search(
            @RequestParam (value = "status",required=false)String status,
            @RequestParam (value = "project",required=false)String project,
            @RequestParam (value = "priority",required=false)String priority,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam (required = false)String[] sortBy)
    {
        List<Task> list = taskService.search(pageNo, pageSize,status,project,priority,sortBy);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

         