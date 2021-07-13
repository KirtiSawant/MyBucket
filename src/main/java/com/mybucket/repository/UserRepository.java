package com.mybucket.repository;

import com.mybucket.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    String  deleteById(int uid);
  //  List<User> findAll();


}
