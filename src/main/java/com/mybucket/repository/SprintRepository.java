package com.mybucket.repository;

import com.mybucket.dto.StatusResponse;
import com.mybucket.model.Sprint;
import com.mybucket.model.Task;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends CrudRepository<Sprint,Integer> {
    //@Query("select t.sid,t.t_id,s.name,s.description,s.start_date,s.end_date,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from sprint s INNER JOIN task t ON s.sid=t.t_id  ")
    List<Sprint> findAll();
    @Query(value = "SELECT t.sid,t.t_id,s.name,s.description,s.start_date,s.end_date,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour from sprint s INNER JOIN task t ON s.sid=t.t_id where t.status=:status")
    StatusResponse findByStatus(String status);
}
