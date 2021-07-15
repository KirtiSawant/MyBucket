package com.mybucket.repository;

import com.mybucket.controller.TaskDetails;
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
  /*  @Query("SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid where t.uid=:uid")
   // @Query("SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from task t INNER JOIN user u ON u.uid=t.uid")
    List<Task> findTaskByUser(@Param("uid") int uid);*/

   // @Query("select new com.mybucket.model.TaskJoin(t.t_id,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour,t.uid,t.user_name) from task t, user u where t.user = u")
    @Query("SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid where t.uid=:uid")
    List<TaskJoin> findTaskUser(@Param("uid") int uid);
    @Query("SELECT t.uid,u.user_name,SUM(t.estimated_hour)  FROM user u INNER JOIN task t ON u.uid=t.uid where t.status=:status")
    List<Task> findStatus(String status);


    //@Query("select * from task t where t.project=:project")
     Page<Task> findByProject(String project,Pageable paging );
     Page<Task> findByStatus( String status, Pageable paging);
    // List<Task> findByStatus(String status,Sort sort);
     Page<Task> findByPriority(String priority,Pageable paging);
}
