package com.mybucket.task.repo;

import com.mybucket.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    private static final String INSERT_TASK_QUERY="INSERT INTO TASK(tid,description,priority,status,hour_spent,estimated_hour) values(?,?,?,?,?,?)";
    private static final String UPDATE_TASK_QUERY="UPDATE TASK SET description=?,hour_spent=?,estimated_hour=? WHERE tid=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Task saveTask(Task task) {
        jdbcTemplate.update(INSERT_TASK_QUERY,task.getTid(),task.getDescription(),task.getPriority(),task.getStatus(),task.getHour_spent(),task.getEstimated_hour());
        return task;
    }
    @Override
    public Task updateTask(Task task) {
        jdbcTemplate.update(UPDATE_TASK_QUERY,task.getTid(),task.getPriority(),task.getHour_spent(),task.getEstimated_hour(),task.getDescription());
        return task;
    }





}
