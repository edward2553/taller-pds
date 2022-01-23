package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.Project;
import com.taller.pds.tallerpds.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public List<Project> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Project create(@RequestBody  Project project){
        return service.create(project);
    }

}
