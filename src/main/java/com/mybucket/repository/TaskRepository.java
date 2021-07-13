package com.mybucket.repository;

import com.mybucket.controller.TaskDetails;
import com.mybucket.model.Priority;
import com.mybucket.model.Status;
import com.mybucket.model.Task;
import com.mybucket.model.TaskJoin;
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


    @Query("SELECT u.uid,u.user_name,SUM(t.estimated_hour)  FROM task t INNER JOIN user u ON u.uid=t.t_id where t.status=:status GROUP BY u.uid,u.user_name")
    List<Task> findStatus(String status);

    List<Task> findByStatus(Status status, Sort sort);
    //@Query("select * from task t where t.project=:project")
   List<Task> findByProject(String project );
  //  @Query("select * from task t where t.status=:status & t.priority=:priority")
    Page<Task> findByStatus( String status, Pageable paging);
    List<Task> findByStatus(String status,Sort sort);

    Page<Task> findByPriority(String priority, Pageable paging);
}
