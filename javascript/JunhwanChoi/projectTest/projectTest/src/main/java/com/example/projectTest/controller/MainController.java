package com.example.projectTest.controller;

import com.example.projectTest.service.MainService;
import com.example.projectTest.vo.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MainController {

    MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/covid19")
    public void getCovid19(){
        ResponseEntity<String> responseEntity = mainService.getAPi();
        Response response = mainService.parser(responseEntity.getBody());

        System.out.println(response);
    }
}