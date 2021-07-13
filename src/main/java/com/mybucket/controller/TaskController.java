package com.mybucket.controller;

import com.mybucket.enums.Direction;
import com.mybucket.enums.OrderBy;
import com.mybucket.model.Task;
import com.mybucket.model.TaskJoin;
import com.mybucket.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

/*
   @GetMapping("/task")
    public List<Task> getTasks(@RequestParam("page") int page){
        return taskService.getTasks();
    }

    @GetMapping("task")
    public List<Task> findAllBySortAndPage(@RequestParam("page") final int page, @RequestParam("size") final int size,
                                           @RequestParam("sortBy") final String sortBy, @RequestParam("sortOrder") final String sortOrder) {
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortOrder), sortBy);
        Page<Task> result = taskService.findAll(pageable);
        if (!result.isEmpty())
            return result.getContent();
        else
            return new ArrayList<Task>();
    }
*/
   @GetMapping("/task/user/{uid}")
        public List<TaskJoin> getTaskForUser(@PathVariable("uid") int uid){
        return taskService.getTaskForUser(uid);
        }

    @GetMapping("/task/{tId}")
    public Task getTask(@PathVariable("tId")int tId){
        return taskService.getTask(tId);
    }

    @PutMapping("task/{tId}")
    public Task updateTask(@PathVariable("tId") int tId, @RequestBody Task task) {
        return taskService.updateTask(tId,task);
    }
    @DeleteMapping("/task/{tId}")
    public String  delete(@PathVariable("tId")int tId){
       return taskService.deleteTask(tId);
    }
    @GetMapping("/taskEstimatedHour")
    public List<Task> getEstimatedHours(@RequestParam String status){
        return taskService.getEstimatedHours(status);
    }
    @GetMapping("/task/project")
    public List<Task> getProject(@RequestParam String project){
        return taskService.getProject(project);
    }

    @GetMapping("tasks/status")
    public ResponseEntity<List<Task>> getAllTask(
            @RequestParam (defaultValue = "false")String status,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "tId") String sort[])
    {
        List<Task> list = taskService.getAllTask(pageNo, pageSize, sort,status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
/*

    @GetMapping("tasks/status")
    public ResponseEntity<List<Task>> getAllTask(
            @RequestParam (defaultValue = "false")String status,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "tId") String sort[])
    {
        List<Task> list = taskService.getAllTask(pageNo, pageSize, sort,status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
*/
/*

    @GetMapping(value = "/conditionalPagination", params = { "orderBy", "direction", "page","size" })
    public Page<Task> findJsonDataByPageAndSize(@RequestParam("orderBy") String orderBy,
                                                @RequestParam("direction") String direction,
                                                @RequestParam("page") int page,
                                                @RequestParam("size") int size) {

        if (!(direction.equals(Direction.ASCENDING.getDirectionCode())
                || direction.equals(Direction.DESCENDING.getDirectionCode())))

            if (!(orderBy.equals(OrderBy.ID.getOrderByCode()) || orderBy.equals(OrderBy.USERID.getOrderByCode()))) {
}
Page<Task> list = taskService.findJsonDataByCondition(orderBy, direction, page, size);
return list;
}


    /*
    @GetMapping(value = "tasks")
    public List<Task> getTaskAllPriority(@RequestParam(defaultValue = "0") final int page,
                                           @RequestParam(defaultValue = "5") final int size,
                                           @RequestParam(defaultValue = "tId") final String sortBy,
                                           @RequestParam(defaultValue="sortOrder") final String sortOrder) {
        List<Task> list = taskService.getTaskAllPriority(page, size, sortBy,sortOrder);
        return (List<Task>) new ResponseEntity<List<Task>>(list, new HttpHeaders(), HttpStatus.OK);

    }

*/

}
