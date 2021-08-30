package com.mybucket.dto;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    private int uid;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String dob;

}
