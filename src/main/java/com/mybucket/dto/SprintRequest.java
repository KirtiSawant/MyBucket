package com.mybucket.dto;

import com.mybucket.enums.Status;
import com.mybucket.model.Sprint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SprintRequest {

    private List<String> name;
    private Status status;
    private int statuscount;


}
