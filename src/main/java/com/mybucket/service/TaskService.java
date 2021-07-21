package com.mybucket.service;


import com.mybucket.model.*;
import com.mybucket.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;


  //  @Autowired
  //  UserRepository userRepository;

    public Task addTask(Task task) {
      //  User user = new User();
      //  user.setTask(task);
     /*   User user2 = task.getUid();
        if(user2 != null){
            int uid = 1;
            Optional<User> user=userRepository.findById(uid);
            if(user.isPresent()){
                task.setUid(user.get());
            }
        }*/
        return taskRepository.save(task);
    }

  //  public List<Task> getTasks() {return (List<Task>) taskRepository.findAll();}

    public List<TaskJoin> getTaskForUser(int uid) {
        return (List<TaskJoin>) taskRepository.findTaskUser(uid);
    }

    public Task getTask(int tId) {
        return taskRepository.findById(tId).get();
    }

    public Task updateTask(int tId, Task task) {
        task.settId(tId);
        return taskRepository.save(task);
    }

    public String deleteTask(int tId) {
        taskRepository.deleteById(tId);
        return "Task Deleted";
    }
    public List<GroupUser> getEstimatedHours(String status) {
        return taskRepository.sumByStatus(status);
    }

/*

    public List<TaskJoin> search(Integer pageNo, Integer pageSize,String status ,String project,String priority,String userName) {
        List<TaskJoin> tutorials = new ArrayList<TaskJoin>();
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<TaskJoin> pageResult;
        if (status == null  && project==null && priority==null && userName==null)
            pageResult =  taskRepository.findAll(paging);
        else
            pageResult = (Page<TaskJoin>) taskRepository.findByStatusAndProjectAndPriorityAndUserName(status, project,priority,userName,paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<TaskJoin>();
        }
    }

    */

    public List<Task> search(Integer pageNo, Integer pageSize,String status ,String project,String priority) {
      // List<Sort.Order> orders = new ArrayList<Sort.Order>();
          //orders.add(new Sort.Order(getSortDirection().isAscending()));
     // Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "project");
    //   orders.add(order1);
       Sort sortOrder = Sort.by("estimatedHour");
        List<Task> list = taskRepository.findAll(sortOrder);
       //List<Task> list = taskRepository.findByStatusOrProject(status,project,sort);
        if (list.isEmpty()) {
            return list;
        }
        Pageable paging = PageRequest.of(pageNo, pageSize,sortOrder);
        Page<Task> pageResult;
        if (status == null  && project==null && priority==null)
            pageResult = taskRepository.findAll(paging);
        else
            pageResult = taskRepository.findByStatusAndProjectAndPriority(status, project,priority,paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }





}









