package com.mybucket.service;

import com.mybucket.dto.SprintResponse;
import com.mybucket.dto.StatusResponse;
import com.mybucket.dto.UserResponse;
import com.mybucket.exception.SprintNotFoundException;
import com.mybucket.model.Sprint;
import com.mybucket.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
    @Autowired
    SprintRepository sprintRepository;

    public Sprint createSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }
    public List<Sprint> getAllSprint() {
        return (List<Sprint>) sprintRepository.findAll();
    }
    public List<Sprint> getTask() {
        return  sprintRepository.findAll();
    }

    public Sprint getSprintById(int sid) {
        return sprintRepository.findById(sid).orElseThrow(() -> new SprintNotFoundException(sid));
    }
    public Sprint updateSprint(int sid, Sprint sprint) {
        sprint.setSid(sid);
        return   sprintRepository.save(sprint);
    }
    public String deleteSprint(int sid) {
        sprintRepository.deleteById(sid);
        return "Sprint sid";
    }

    public StatusResponse searchSprint(int sid,String status) {
        return  sprintRepository.findByStatus(status).get(sid);
    }

    public List<UserResponse> searchUserName(String userName) {
        return sprintRepository.findByUserName(userName);
    }

    public List<SprintResponse> getstatus(String status) {
        return sprintRepository.findAllByStatus(status);
    }
}

