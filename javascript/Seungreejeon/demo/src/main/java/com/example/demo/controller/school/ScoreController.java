package com.example.demo.controller.school;


import com.example.demo.entity.Student;
import com.example.demo.service.VueStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/school")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ScoreController {

    @Autowired
    private VueStudentService service;

    @PostMapping("/register")
    public ResponseEntity<Student> studentRegister(@RequestBody Student student) throws Exception {
        log.info("data from vue");

        log.info(student+ "student");

        service.register(student);

        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Student>> requestStudentList() throws Exception {
        log.info("return Lists to vue");


        return new ResponseEntity<List<Student>>(service.list(), HttpStatus.OK);

    }

}
