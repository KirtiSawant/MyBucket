package com.mybucket.user.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="UserName")
    @NotEmpty(message = "User Name is mandatory")
    private String userName;
    @Column(name="First_Name")
    @NotEmpty(message = "First name is required")
    private String firstName;
    @Column(name="Last_Name")
    private String lastName;
    @Column(name="Email")
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @Column(name="DateOfBirth")
    private String dob;

    public User(int id,String userName,String firstName, String lastName, String email,String  dob) {
    this.id=id;
    this.userName=userName;
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.dob=dob;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
