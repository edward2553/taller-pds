package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.Backlog;
import com.taller.pds.tallerpds.services.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backlog")
public class BacklogController {

    @Autowired
    private BacklogService service;

    @GetMapping
    public List<Backlog> findAll() { return service.findAll(); }

    @PostMapping
    public Backlog create(@RequestBody Backlog backlog){
        return service.create(backlog);
    }

}
