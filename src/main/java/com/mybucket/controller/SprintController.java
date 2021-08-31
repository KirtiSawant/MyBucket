package com.mybucket.controller;

import com.mybucket.dto.*;
import com.mybucket.model.Sprint;
import com.mybucket.service.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class SprintController {
    @Autowired
    ModelMapper modelMapper;


    @Autowired
    SprintService sprintService;


   /* @PostMapping("sprint")
    public Sprint createSprint(@Valid @RequestBody Sprint sprint){

        return sprintService.createSprint(sprint);
    }*/
   @PostMapping("sprint")
   public ResponseEntity<SprintDto> createSprint(@RequestBody Sprint SprintDto) {

       // convert DTO to entity
       Sprint sprintRequest = modelMapper.map(SprintDto, Sprint.class);

       Sprint sprint = sprintService.createSprint(sprintRequest);

       SprintDto postResponse = modelMapper.map(sprint, SprintDto.class);

       return new ResponseEntity<SprintDto>(postResponse, HttpStatus.CREATED);
   }

    @GetMapping("sprint")
    public List<SprintDto> getAllSprint() {
        return sprintService.getAllSprint().stream().map(sprint -> modelMapper.map(sprint, SprintDto.class))
                .collect(Collectors.toList());
    }

   /* @GetMapping("/sprint/{sid}")
    public Sprint getSprintById(@PathVariable("sid") int sid) {
        return sprintService.getSprintById(sid);
    }*/

    @GetMapping("sprint/{sid}")
    public ResponseEntity<SprintDto> getSprintById(@PathVariable(name = "sid") int sid) {
        Sprint sprint = sprintService.getSprintById(sid);

        // convert entity to DTO
        SprintDto sprintResponse = modelMapper.map(sprint, SprintDto.class);

        return ResponseEntity.ok().body(sprintResponse);
    }
    @PutMapping("/sprint/{sid}")
    public Sprint updateSprint(@PathVariable("sid") int sid, @RequestBody Sprint sprint) {
        return sprintService.updateSprint(sid,sprint);
    }
    @DeleteMapping("/sprint/{sid}")
    public String deleteSprint(@PathVariable("sid") int sid) {
       return sprintService.deleteSprint(sid);
    }

    /*   Additional API   */

   @GetMapping("sprint/status/name")
    public List<StatusResponse> searchSprint(@RequestParam String status,@RequestParam String name){
       return sprintService.searchSprint(status,name);
   }
    @GetMapping("sprint/tasks/{sid}")
    public Sprint getTask(@PathVariable(name = "sid") int sid){
        return sprintService.getTask(sid);
    }

    @GetMapping("sprint/userName")
    public List<UserResponse> searchUserName(@RequestParam String userName,String name){
        return sprintService.searchUserName(userName,name).stream().map(sprint -> modelMapper.map(sprint, UserResponse.class))
                .collect(Collectors.toList());
    }
    @GetMapping("sprint/statusCount")
    public List<SprintResponse> getStatus(@RequestParam String status,@RequestParam String name){
       return sprintService.getstatus(status,name);
    }

    @GetMapping("sprint/count")
    public List<SprintResponse> getAllSprintCount(@RequestParam String status){
       return sprintService.getAllSprintCount(status);
    }
  @GetMapping("sprint/user/task")
   public List<UserResponse> searchUserTaskStatus(@RequestParam String userName,String name,String status){
        return sprintService.searchUserTaskStatus(userName,name,status).stream().map(sprint -> modelMapper.map(sprint, UserResponse.class))
                .collect(Collectors.toList());
    }
    @GetMapping("sprints/tasks")
    public List<StatisticsSprintResponse> getAllTaskSprint(@RequestParam List<String> name){

        return sprintService.getAllTaskSprint(name).stream().map(sprintRequest -> modelMapper.map(sprintRequest, StatisticsSprintResponse.class))
                .collect(Collectors.toList());
    }
    @GetMapping("sprint/user")
    public List<StatisticsSprintUser> getStatisticsSprint(@RequestParam String name,@RequestParam String userName){
       return sprintService.getStatisticsSprint(name,userName);
    }

}
