package com.mybucket.task.repo;

import com.mybucket.task.model.Task;
import com.mybucket.user.model.User;

import java.util.List;


public interface TaskRepository{
    Task saveTask(Task task);
    Task updateTask(Task task);
//    Task getById(int tid);
  //  Task findByDescription(Task task)
//    String deleteById(int id);
   // List<Task> allTask();

}
