package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.ProjectTask;
import com.taller.pds.tallerpds.helper.Helpers;
import com.taller.pds.tallerpds.helper.ResponseBuilder;
import com.taller.pds.tallerpds.model.Response;
import com.taller.pds.tallerpds.services.ProjectTaskService;
import com.taller.pds.tallerpds.types.EStatusTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class ProjectTaskController {

    private final ProjectTaskService service;
    private final ResponseBuilder builder;
    private final Helpers helpers;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/project/{projectIdentifier}")
    public List<ProjectTask> findAllByProjectIdentifier(@PathVariable("projectIdentifier") String projectIdentifier){
        return service.findByProjectId(projectIdentifier);
    }

    @GetMapping("/hours/project/{projectIdentifier}")
    public Double getProjectHours(@PathVariable("projectIdentifier") String projectIdentifier) {
        return service.getProjectHours(projectIdentifier);
    }

    @GetMapping("/hours/project/{projectIdentifier}/{status}")
    public Double getProjectHoursByStatus(@PathVariable("projectIdentifier") String projectIdentifier,@PathVariable("status") EStatusTypes status) {
        return service.getProjectHoursByStatus(projectIdentifier, status);
    }
    @DeleteMapping("/{taskId}/{projectIdentifier}")
    public ProjectTask removeTask(@PathVariable("taskId") Long taskId,@PathVariable("projectIdentifier") String projectIdentifier) {
        return service.removeTask(taskId, projectIdentifier);
    }

    @PostMapping
    public Response create(@Valid @RequestBody ProjectTask projectTask, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return builder.failed(helpers.formatMessage(validationResult));
        }
        service.create(projectTask);
        return builder.success(projectTask);
    }

}
