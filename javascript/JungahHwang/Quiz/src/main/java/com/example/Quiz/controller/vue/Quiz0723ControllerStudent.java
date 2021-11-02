package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.Student;
import com.example.Quiz.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RequestMapping("/vuestudent")
public class Quiz0723ControllerStudent {
    @Autowired
    private StudentService service;

    @GetMapping("/score")
    public ResponseEntity<List<Student>> studentList() throws Exception {
        log.info("studentList");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
}
