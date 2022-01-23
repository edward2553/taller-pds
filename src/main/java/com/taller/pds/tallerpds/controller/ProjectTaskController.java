package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.services.ProjectTaskService;
import com.taller.pds.tallerpds.types.EStatusTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService service;

/*
    @GetMapping
    public List<Course> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Course create(@RequestBody Course course){
        return service.create(course);
    }
*/

    @GetMapping
    public List<ProjectTask> findAllByProjectIdentifier(String projectIdentifier){
        return service.findByProjectId(projectIdentifier);
    }

    @GetMapping
    public Integer getProjectHours(String projectIdentifier) {
        return service.getProjectHours(projectIdentifier);
    }

    @GetMapping
    public Integer getProjectHoursByStatus(String projectIdentifier, EStatusTypes status) {
        return service.getProjectHoursByStatus(projectIdentifier, status);
    }
    @DeleteMapping
    public void removeTask(Long taskId, String projectIdentifier) {
        service.removeTask(taskId, projectIdentifier);
    }

    @PostMapping
    public ProjectTask create(@RequestBody ProjectTask projectTask) {
        return service.create(projectTask);
    }

}
