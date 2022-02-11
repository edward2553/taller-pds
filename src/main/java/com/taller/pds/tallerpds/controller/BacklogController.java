package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.Backlog;
import com.taller.pds.tallerpds.helper.Helpers;
import com.taller.pds.tallerpds.helper.ResponseBuilder;
import com.taller.pds.tallerpds.services.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/backlog")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService service;
    private final ResponseBuilder builder;
    private final Helpers helpers;

    @GetMapping
    public ResponseEntity findAll() { return new ResponseEntity<>(service.findAll(), HttpStatus.OK); }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Backlog backlog, BindingResult validationResult){
        if (validationResult.hasErrors()) {
            return new ResponseEntity<>(builder.failed(helpers.formatMessage(validationResult)), HttpStatus.BAD_REQUEST);
        }
        service.create(backlog);
        return new ResponseEntity<>(builder.successCeated(backlog), HttpStatus.CREATED);
    }



}
