package com.mybucket.service;


import com.mybucket.model.*;
import com.mybucket.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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



    public List<Task> searchStatus(Integer pageNo, Integer pageSize, String[] sortby, String status) {

        //List<Sort.Order> orders = new ArrayList<Sort.Order>();
        //   orders.add(new Sort.Order(getSortDirection().isAscending()));
      /*  Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "project");
        orders.add(order1);
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "priority");
        orders.add(order2);*/


        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("project").descending().and(Sort.by("priority")));
        Page<Task> pageResult;
        if (status == null)
            pageResult = taskRepository.findAll(paging);
        else
            pageResult = taskRepository.findByStatus(status, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }

    public List<Task> searchProject(Integer pageNo, Integer pageSize, String[] sort, String project) {
      //  Sort sort =  Sort.by("status").descending().and(Sort.by("priority").descending());

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("status").descending().and(Sort.by("priority")));
        Page<Task> pageResult;
        if (project == null)
            pageResult = taskRepository.findAll(paging);
        else
            pageResult = taskRepository.findByProject(project, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }
    public List<Task> searchPriority(Integer pageNo, Integer pageSize, String[] sort, String priority) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("status").descending().and(Sort.by("project")).descending());
        Page<Task> pageResult;
        if (priority == null)
            pageResult = taskRepository.findAll(paging);
        else
            pageResult = taskRepository.findByPriority(priority, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }
/*
    public List<TaskJoin> searchUser(Integer pageNo, Integer pageSize, String[] sort, String userName) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("t_id").descending());
        Page<TaskJoin> pageResult;

          //  pageResult = (Page<TaskJoin>) taskRepository.findAll(paging);

            pageResult =  taskRepository.findByUserName(userName, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<TaskJoin>();
        }
    }
    */

}









