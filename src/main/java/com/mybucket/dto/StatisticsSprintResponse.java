package com.mybucket.dto;

import com.mybucket.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsSprintResponse {

    private String name;
    private int statusdone;
    private int statustodo;
    private int statusinprogress;
}
