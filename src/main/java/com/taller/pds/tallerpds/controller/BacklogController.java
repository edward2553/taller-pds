package com.taller.pds.tallerpds.controller;

import com.taller.pds.tallerpds.entities.Backlog;
import com.taller.pds.tallerpds.helper.Helpers;
import com.taller.pds.tallerpds.helper.ResponseBuilder;
import com.taller.pds.tallerpds.model.Response;
import com.taller.pds.tallerpds.services.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/backlog")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService service;
    private final ResponseBuilder builder;
    private final Helpers helpers;

    @GetMapping
    public List<Backlog> findAll() { return service.findAll(); }

    @PostMapping
    public Response create(@Valid @RequestBody Backlog backlog, BindingResult validationResult){
        if (validationResult.hasErrors()) {
            return builder.failed(helpers.formatMessage(validationResult));
        }
        service.create(backlog);
        return builder.success(backlog);
    }



}
