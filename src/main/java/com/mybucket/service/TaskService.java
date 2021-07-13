package com.mybucket.service;

import com.mybucket.model.Task;
import com.mybucket.model.TaskJoin;
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

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    public Task addTask(Task task) {
        //  User user = new User();
        // user.setTask(task);
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

    public List<Task> getProject(String project) {
        return taskRepository.findByProject(project);
    }
    /*

    public List<Task> getAllTask(Integer pageNo, Integer pageSize, String[] sort, String status)
    {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(getSortDirection().isAscending()));
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


/*
    public List<Task> getAllTask(Integer pageNo, Integer pageSize, String[] sort, String status)
    {
       List<Sort.Order> orders = new ArrayList<Sort.Order>();
      // Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "project");
     //  orders.add(order1);

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
        Sort sort = null;
        if (direction.equals("ASC")) {
            sort = new Sort.Order(Direction.ASC,orderBy));
        }
        if (direction.equals("DESC")) {
            sort = new Sort(new Sort.Order(Direction.DESC,orderBy));
        }
        PageRequest pageable = PageRequest.of(page, size, sort);
        Page<Task> data = taskRepository.findAll(pageable);
        return data;
    }
   /* public List<Task> getTaskAll(int page, int size, String sortBy, String sortOrder) {
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortOrder), sortBy);
        Page<Task> result = taskRepository.findAll(pageable);
        if (!result.isEmpty())
            return result.getContent();
        else
            return new ArrayList<Task>();
    }*/
    }

