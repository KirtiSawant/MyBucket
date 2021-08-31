package com.mybucket.dto;


import com.mybucket.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SprintResponse {

        private int sid;
        private String name;
        private Status status;
        private int statuscount;



    }


