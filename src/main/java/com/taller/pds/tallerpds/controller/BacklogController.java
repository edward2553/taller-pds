package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.Backlog;
import com.taller.pds.tallerpds.services.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backlog")
public class BacklogController {

    @Autowired
    private BacklogService service;

    @PostMapping
    public Backlog create(@RequestBody Backlog backlog){
        return service.create(backlog);
    }

}
