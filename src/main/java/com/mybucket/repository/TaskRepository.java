package com.mybucket.repository;

import com.mybucket.controller.TaskDetails;
import com.mybucket.enums.Status;
import com.mybucket.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task,Integer> {

    List<Task> findAll();

      @Query("SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid where t.uid=:uid")
    List<TaskJoin> findTaskUser(@Param("uid") int uid);
      @Query(value = "select t.uid,t.t_id,u.user_name,t.status,sum(t.estimated_hour) as estimated_hour from task t INNER JOIN user u ON u.uid=t.uid where t.status=:status GROUP BY u.user_name")
     List<GroupUser> sumByStatus(String status);

    Page<Task>findAll(Pageable pageable);

     Page<Task> findByProject(String project,Pageable paging );
     Page<Task> findByStatus( String status, Pageable paging);
     Page<Task> findByPriority(String priority,Pageable paging);
  //   @Query(value = "SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid where u.user_name=:user_name")
  //  Page<TaskJoin> findByUserName(String userName, Pageable paging);
     //List<TaskJoin>findAll(Pageable paging);
}
