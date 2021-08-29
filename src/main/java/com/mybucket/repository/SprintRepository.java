package com.mybucket.repository;

import com.mybucket.dto.SprintResponse;
import com.mybucket.dto.StatusResponse;
import com.mybucket.dto.UserResponse;
import com.mybucket.model.Sprint;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends CrudRepository<Sprint,Integer> {

    List<Sprint> findAll();
    @Query(value = "SELECT s.name,s.description,s.start_date,s.end_date,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM task t JOIN sprint s ON t.sid=t.t_id where t.status=:status")
    List<StatusResponse> findByStatus(String status);

   // @Query(" SELECT u.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM task t JOIN user u ON u.uid=t.t_id where user_name=:user_name")
   //@Query("select * from task where uid IN(select uid from user where user_name=:user_name)")
   @Query(" SELECT  s.name,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM sprint s JOIN user u ON u.uid=s.sid join task t on t.uid=t.t_id where user_name=:user_name")
    List<UserResponse> findByUserName(String user_name);

   // @Query("select s.sid,t.t_id,s.name,COUNT(t.status) AS status from task t join sprint s  on t.t_id=t.sid where t.status=:status")
    @Query("SELECT s.sid,s.name, count(t.status) as statuscount FROM  sprint s  INNER JOIN task t USING (sid) where t.status=:status")
    List<SprintResponse> findAllByStatus(String status);
}
