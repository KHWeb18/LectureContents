package com.example.demo.controller.vue.jpa;

import com.example.demo.service.jpa.TestStudentService;
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
public class JPATestStudentController {

    @Autowired
    private TestStudentService service;

    @GetMapping("/StudentTest")
    public void getJPATest() throws Exception {
        log.info("getJPATest() - findByJPQL: " + service.findByJPQL());

        List<Object[]> result = service.findSpecificByJPQL();

        for(int i=0; i<result.size(); i++) {
            System.out.println("getJPATest() - findSpecificByJPQL: " + Arrays.toString(result.get(i)));
        }
    }
}
