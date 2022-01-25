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

    @GetMapping
    public List<ProjectTask> findAll(){
        return service.findAll();
    }

    @GetMapping("/project/{projectIdentifier}")
    public List<ProjectTask> findAllByProjectIdentifier(@PathVariable("projectIdentifier") String projectIdentifier){
        return service.findByProjectId(projectIdentifier);
    }

    @GetMapping("/hours/project/{projectIdentifier}")
    public Integer getProjectHours(@PathVariable("projectIdentifier") String projectIdentifier) {
        return service.getProjectHours(projectIdentifier);
    }

    @GetMapping("/hours/project/{projectIdentifier}/{status}")
    public Integer getProjectHoursByStatus(@PathVariable("projectIdentifier") String projectIdentifier,@PathVariable("status") EStatusTypes status) {
        return service.getProjectHoursByStatus(projectIdentifier, status);
    }
    @DeleteMapping("/{taskId}/{projectIdentifier}")
    public void removeTask(@PathVariable("taskId") Long taskId,@PathVariable("projectIdentifier") String projectIdentifier) {
        service.removeTask(taskId, projectIdentifier);
    }

    @PostMapping
    public ProjectTask create(@RequestBody ProjectTask projectTask) {
        return service.create(projectTask);
    }

}
