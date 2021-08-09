package com.example.personalProject.controller.jpa;


import com.example.personalProject.service.jpa.JPATestMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        log.info("getJPATest - (): " + service.findByJPQL());

        List<Object[]> resultLists = service.findSpecificByJPQL();

        for(Object[] result : resultLists) {
            log.info("getJPATest- findSpecificByJPQL(): " + Arrays.toString(result));
        }
    }
}