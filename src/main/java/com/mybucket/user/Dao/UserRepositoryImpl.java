package com.mybucket.user.Dao;

import com.mybucket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static final String INSERT_USER_QUERY="INSERT INTO USER(id,userName,firstName,lastName,email,dob) values(?,?,?,?,?,?)";
    private static final String UPDATE_USER_BY_ID_QUERY="UPDATE USER SET userName=?,firstName=?,lastName=?,email=?,dob=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY="select * from user where id=?";
    private static final String DELETE_USER_BY_ID="DELETE FROM USER WHERE id=?";
    private static final String GET_USER_QUERY="SELECT * FROM USER";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY,user.getId(),user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getDob());
        return user;
    }
    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY,user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getId());
        return user;
    }


    @Override
    public User getById(int id) {
    return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY,(rs, rowNum) ->{
                return new User(rs.getInt("id"),rs.getString("userName"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getString("dob"));
            },id);

    }
    @Override
    public String  deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID,id);
        return "User got deleted id"+id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USER_QUERY,(rs, rowNum) -> {
            return new User(rs.getInt("id"),rs.getString("userName"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getString("dob"));
        });
    }
}
