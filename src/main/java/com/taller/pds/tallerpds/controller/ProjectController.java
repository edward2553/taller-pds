package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.Project;
import com.taller.pds.tallerpds.helper.Helpers;
import com.taller.pds.tallerpds.helper.ResponseBuilder;
import com.taller.pds.tallerpds.model.Response;
import com.taller.pds.tallerpds.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;
    private final ResponseBuilder builder;
    private final Helpers helpers;

    @GetMapping
    public List<Project> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Response create(@Valid @RequestBody  Project project, BindingResult validationResult){
        if (validationResult.hasErrors()) {
            return builder.failed(helpers.formatMessage(validationResult));
        }
        service.create(project);
        return builder.success(project);
    }

}
