package com.mybucket.controller;

import com.mybucket.dto.*;
import com.mybucket.model.Sprint;
import com.mybucket.service.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/sprint/{sid}")
    public Sprint getSprintById(@PathVariable("sid") int sid) {
        return sprintService.getSprintById(sid);
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

   @GetMapping("sprint/{sid}/status")
    public StatusResponse searchSprint(@PathVariable("sid") int sid,@RequestParam String status){
       return sprintService.searchSprint(sid,status);
   }
    @GetMapping("sprint/task")
    public List<Sprint> getTask(){
        return sprintService.getTask();
    }

    @GetMapping("sprint/userName")
    public List<UserResponse> searchUserName(@RequestParam String userName){
        return sprintService.searchUserName(userName).stream().map(sprint -> modelMapper.map(sprint, UserResponse.class))
                .collect(Collectors.toList());
    }
    @GetMapping("sprint/statusCount")
    public List<SprintResponse> getStatus(@RequestParam String status){
       return sprintService.getstatus(status);
    }
}
