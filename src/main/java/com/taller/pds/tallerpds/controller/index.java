package com.taller.pds.tallerpds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class index {
    @GetMapping
    public ResponseEntity initialRoute(){
        return new ResponseEntity<>("Initial Route", HttpStatus.OK);
    }
}
