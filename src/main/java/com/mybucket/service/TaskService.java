package com.mybucket.service;


import com.mybucket.dto.StatusResponse;
import com.mybucket.model.*;
import com.mybucket.repository.SprintRepository;
import com.mybucket.repository.TaskRepository;
import com.mybucket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.*;


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

      @Autowired
      UserRepository userRepository;
     @Autowired
     SprintRepository sprintRepository;

    public Task addTask(Task task) {
        //  User user = new User();
        //  user.setTask(task);

        /*    User user2 = task.getUsers();
        if(user2 != null){
            int uid = 1;
            Optional<User> user=userRepository.findById(uid);
            if(user.isPresent()){
                task.setUsers(user.get());
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



    public List<Task> search(Integer pageNo, Integer pageSize, String status, String project, String priority,String[] sortBy) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        if (sortBy[0].contains(",")) {
            for (String sortOrder : sortBy) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {

            orders.add(new Sort.Order(getSortDirection(sortBy[1]), sortBy[0]));
        }

        Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(orders));
        Page<Task> pageResult;
        if(status!=null && project!=null && priority!=null)
            pageResult = taskRepository.findByStatusAndProjectAndPriority(status, project, priority, paging);

        else if(status!=null && project!=null && priority==null)
            pageResult = taskRepository.findByStatusAndProject(status,project,paging);

        else if(status!=null && priority!=null && project==null)
            pageResult = taskRepository.findByStatusAndPriority(status,priority,paging);

        else if(project!=null && priority!=null && status==null)
            pageResult = taskRepository.findByProjectAndPriority(project,priority,paging);

        else if(project!=null && priority==null && status==null)
            pageResult = taskRepository.findByProject(project,paging);

        else if(project==null && priority!=null && status==null)
            pageResult = taskRepository.findByPriority(priority,paging);

        else if(project==null && priority==null && status!=null)
            pageResult = taskRepository.findByStatus(status,paging);

        else
            pageResult = taskRepository.findAll(paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Task>();
        }
    }

}










