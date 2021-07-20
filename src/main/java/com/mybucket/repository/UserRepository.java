package com.mybucket.repository;

import com.mybucket.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    String  deleteById(int uid);
    @Query(value = "select uid,user_name,first_name,last_name,email,dob from user ")
    List<User>findAll();




}
