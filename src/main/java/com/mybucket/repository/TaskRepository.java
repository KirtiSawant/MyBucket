package com.mybucket.repository;

import com.mybucket.dto.StatusResponse;
import com.mybucket.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task,Integer> {

    List<Task> findAll();

    List<Task> findAll(Sort sort);

    @Query("SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid where t.uid=:uid")
    List<TaskJoin> findTaskUser(@Param("uid") int uid);

    @Query(value = "select t.uid,t.t_id,u.user_name,t.status,sum(t.estimated_hour) as estimated_hour from task t INNER JOIN user u ON u.uid=t.uid where t.status=:status GROUP BY u.user_name")
    List<GroupUser> sumByStatus(String status);
    Page<Task>findAll(Pageable pageable);

    Page<Task> findByStatusAndProjectAndPriority(String status, String project, String priority,Pageable paging);

    Page<Task> findByStatusAndProject(String status, String project, Pageable paging);

    Page<Task> findByStatusAndPriority(String status, String priority, Pageable paging);

    Page<Task> findByProjectAndPriority(String project, String priority, Pageable paging);

    Page<Task> findByProject(String project, Pageable paging);

    Page<Task> findByPriority(String priority, Pageable paging);

    Page<Task> findByStatus(String status, Pageable paging);

   @Query(value = "SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid")
    List<TaskJoin> findByStatusAndProjectAndPriorityAndUserName(String status, String project, String priority, String userName, Pageable paging);
    //@Query(value = "SELECT t.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from user u INNER JOIN task t ON u.uid=t.uid")
   //Page<TaskJoin> findByStatusAndProjectAndPriorityAndUserName(String status, String project, String priority, String userName, Pageable sort);
    Page<TaskJoin> findAllBy(Pageable paging);

    //@Query("select * from task ")
    StatusResponse findAllByStatus(String status);
}
