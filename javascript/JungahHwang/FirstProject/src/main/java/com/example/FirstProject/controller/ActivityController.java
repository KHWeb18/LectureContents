package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Activity;
import com.example.FirstProject.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Validated @RequestBody Activity activity) throws Exception {
        log.info("register");

        service.register(activity);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}




















