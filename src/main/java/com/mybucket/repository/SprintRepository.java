package com.mybucket.repository;

import com.mybucket.dto.*;
import com.mybucket.model.Sprint;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends CrudRepository<Sprint,Integer> {

    List<Sprint> findAll();
    //@Query(value = "SELECT s.sid,s.name,s.description,s.start_date,s.end_date,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM task t JOIN sprint s ON t.sid=t.t_id where t.status=:status ")
    @Query("SELECT s.sid,s.name,s.description,s.start_date,s.end_date,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM task t JOIN sprint s ON t.sid=s.sid where t.status=:status AND s.name=:name")
    List<StatusResponse> findByStatusAndName(String status,String name);

   // @Query(" SELECT u.uid,t.t_id,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM task t JOIN user u ON u.uid=t.t_id where user_name=:user_name")
   //@Query("select * from task where uid IN(select uid from user where user_name=:user_name)")
  // @Query(" SELECT  s.name,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM sprint s JOIN user u ON u.uid=s.sid join task t on t.uid=t.t_id where user_name=:user_name")
  @Query("SELECT s.name,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour FROM task t JOIN  user u ON t.uid=u.uid join sprint s on t.sid=u.uid where u.user_name=:user_name AND s.name=:name")
    List<UserResponse> findByUserNameANDName(String user_name,String name);

   // @Query("select s.sid,t.t_id,s.name,COUNT(t.status) AS status from task t join sprint s  on t.t_id=t.sid where t.status=:status")
    @Query("SELECT s.sid,s.name,t.status, count(t.status) as statuscount FROM  sprint s  INNER JOIN task t USING (sid) where t.status=:status AND s.name=:name")
    List<SprintResponse> findAllByStatusANDName(String status,String name);
    @Query("SELECT s.sid,s.name,t.status, count(t.status) as statuscount FROM  sprint s  INNER JOIN task t USING (sid) where t.status=:status GROUP BY s.name")
    List<SprintResponse> findByStatus(String status);

    @Query("SELECT s.name,u.user_name,t.description,t.priority,t.status,t.project,t.hour_spent,t.estimated_hour\n" +
            "FROM task t JOIN  user u ON t.uid=u.uid join sprint s on t.sid=u.uid where u.user_name=:user_name AND s.name=:name AND t.status=:status")
    List<UserResponse> findByUserNameANDNameANDStatus(String user_name, String name, String status);

   /* @Query("\n" +
            "SELECT s.sid,s.name,t.status,count( t.status) as statuscount FROM  sprint s\n" +
            "INNER JOIN task t using(sid)  where s.name=:name or s.name=:name group by t.status\n")*/
    @Query("SELECT s.sid,s.name,count(CASE WHEN t.status='DONE' THEN 1 ELSE NULL END) as statusdone,\n" +
            "count(CASE WHEN t.status='TO_DO' THEN 1 ELSE NULL END) as statustodo,\n" +
            "count(CASE WHEN t.status='IN_PROGRESS' THEN 1 ELSE NULL END) as statusinprogress FROM  sprint s\n" +
            "INNER JOIN task t using(sid)  where  s.name=:name or s.name=:name group by s.name;")
    List<StatisticsSprintResponse> findByName(List<String> name);

    @Query("SELECT u.user_name,s.name,count(CASE WHEN t.status='DONE' THEN 1 ELSE NULL END) as statusdone,\n" +
            "count(CASE WHEN t.status='TO_DO' THEN 1 ELSE NULL END) as statustodo,\n" +
            "count(CASE WHEN t.status='IN_PROGRESS' THEN 1 ELSE NULL END) as statusinprogress FROM  sprint s\n" +
            "INNER JOIN task t using(sid) join user u using(uid) where  (s.name=:name and user_name=:user_name)\n" +
            "or (s.name=:name and user_name=:user_name)\n" +
            "group by s.name;")
    List<StatisticsSprintUser> findByNameAndUserName(String name, String user_name);
}
