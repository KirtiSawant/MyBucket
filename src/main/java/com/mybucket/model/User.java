package com.mybucket.model;

import com.mybucket.model.Task;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Table("User")
public class User{
    @Id
    private int uid;

    @NotEmpty(message = "User Name is mandatory")
    private String userName;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @Nullable
    private String lastName;


    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @Nullable
    private String dob;
     @MappedCollection(keyColumn = "uid",idColumn ="uid")
    private Task tasks;

     public  User(int uid,String userName,String firstName,String lastName,String email,String dob,Task tasks){
        this.uid=uid;
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.dob=dob;
        this.tasks=tasks;
    }
    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Task getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks = tasks;
    }
}
