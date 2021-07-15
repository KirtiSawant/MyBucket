package com.mybucket.service;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.mybucket.enums.Direction;
import com.mybucket.model.GroupUser;
import com.mybucket.model.Task;
import com.mybucket.model.TaskJoin;
import com.mybucket.model.User;
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
    // private Sort.Direction getSortDirection(String direction) {

    public Task addTask(Task task) {
      //  User user = new User();
      //  user.setTask(task);
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }

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

    public List<Task> getEstimatedHours(String status) {
        return taskRepository.findStatus(status);
    }

   /* public List<Task> getProject(String project) {
        return taskRepository.findByProject(project);
    }
*/
    /*
    public List<Task> getAllTask(int page, int size, String priority, String status, String project) {
              Pageable paging = PageRequest.of(page, size);

        Page<Task> pageResult;
        if (priority != null && !priority.isEmpty() && status!=null && !status.isEmpty() && project!=null && !project.isEmpty())
            pageResult = taskRepository.findAll(paging);
        else
           pageResult=taskRepository.findByPriority(priority,status,project,paging);

            /*
            pageResult = taskRepository.findByPriority(priority, paging);
        if (status != null && !status.isEmpty())
            pageResult = taskRepository.findAll(paging);
        else
            pageResult = taskRepository.findByStatus(status, paging);
        if (project != null && !project.isEmpty())
            pageResult = taskRepository.findAll(paging);
        else
            pageResult = taskRepository.findByProject(project, paging);*/
/*
        if (pageResult.hasContent()) {
                return pageResult.getContent();
            } else {
                return new ArrayList<Task>();
            }
            // PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "tId")));
        }
    }
    */

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

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("status").and(Sort.by("priority")).descending());
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
}
/*
    private Sort.Direction getSortDirection(String direction) {
       // String direction = null;
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
    
}


/*
    public Object getAllTask(Integer pageNo, Integer pageSize, String[] sort, String status)
    {
       List<Sort.Order> orders = new ArrayList<>();
      // Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "project");
     //  orders.add(order1);
        if (Direction.ASCENDING.equals("ASC")) {
             sort=new Sort.Order(Direction.ASC);
        } else if (Direction.DESCENDING.equals("DESC")) {
            return Sort.Direction.DESC;
        }

    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));

        Page<Task> pageResult;
        if (status == null)
            pageResult = taskRepository.findAll(paging);
        else
        pageResult = taskRepository.findByStatus(status,paging);

        if(pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }

*/
    /*
    public Page<Task> findJsonDataByCondition(String orderBy, String direction, int page, int size) {
        //Sort sort = null;
        if (direction.equals("ASC")) {
             new Sort.Order(Direction.ASC,orderBy);
        }
        if (direction.equals("DESC")) {
            new Sort.Order(Direction.DESC,orderBy);
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction));
        Page<Task> data = taskRepository.findAll(pageable);
        return data;
    }

     */
   /* public List<Task> getTAll(int page, int size, String sortBy, String sortOrder) {
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortOrder), sortBy);
        Sort sort = Sort.by(Direction.fromString("DESC"), "project");
    // Sorted Users
  //  List<User> sortedUsers = (List<User>) userRepository.findAll(sort);

        Page<Task> result = taskRepository.findAll(pageable);
        else
         page<Task> = taskRepository.findByStatus(status, paging);
        if (!result.isEmpty())
            return result.getContent();
        else
            return new ArrayList<Task>();
    }*/


