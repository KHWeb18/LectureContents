package com.example.cholongtest.controller.vue.jpa;


import com.example.cholongtest.service.jpa.JPATestMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/jpa")
@CrossOrigin(origins = "http://localhost:7777", allowedHeaders = "*")
public class JPATestMemberController {

    @Autowired
    private JPATestMemberService service;

    @GetMapping("/jpaMemberTest")
    public void getJPATest () throws Exception {
        log.info("getJPATest()- findByJPQL: " + service.findByJPQL());

        List<Object[]> resultsLists = service.findSpecificByJPQL();

        for(Object[] result : resultsLists ) {
            log.info("getJPATest() - findSpecificByJPQL: " + Arrays.toString(result));
        }
    }
}