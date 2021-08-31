package com.mybucket.service;

import com.amazonaws.services.frauddetector.model.ResourceNotFoundException;
import com.mybucket.dto.SprintResponse;
import com.mybucket.dto.StatusResponse;
import com.mybucket.dto.UserResponse;
import com.mybucket.exception.SprintNotFoundException;
import com.mybucket.model.Sprint;
import com.mybucket.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    public Sprint getTask(int sid) {
        return  sprintRepository.findById(sid).get();
    }

    /*public Sprint getSprintById(int sid) {
        return sprintRepository.findById(sid).orElseThrow(() -> new SprintNotFoundException(sid));
    }*/
    public Sprint getSprintById(int sid) {
        Optional<Sprint> result = sprintRepository.findById(sid);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new SprintNotFoundException(sid);
        }

//		Post post = postRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        //return post;
    }
    public Sprint updateSprint(int sid, Sprint sprint) {
        sprint.setSid(sid);
        return   sprintRepository.save(sprint);
    }
    public String deleteSprint(int sid) {
        sprintRepository.deleteById(sid);
        return "Sprint Deleted";
    }

    public List<StatusResponse> searchSprint(String status ,String name) {
        return sprintRepository.findByStatusAndName(status,name);
    }

    public List<UserResponse> searchUserName(String userName,String name) {
        return sprintRepository.findByUserNameANDName(userName,name);
    }

    public List<SprintResponse> getstatus(String status,String name) {
        return sprintRepository.findAllByStatusANDName(status,name);
    }

    public List<SprintResponse> getAllSprintCount(String status){
        return sprintRepository.findByStatus(status);
    }

    public List<UserResponse> searchUserTaskStatus(String userName, String name, String status) {
        return sprintRepository.findByUserNameANDNameANDStatus(userName,name,status);
    }

    public List<SprintResponse> getAllTaskSprint(String name) {
        return sprintRepository.findByName(name);

    }
}

