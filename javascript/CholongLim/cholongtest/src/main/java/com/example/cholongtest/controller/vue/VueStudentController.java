package com.example.cholongtest.controller.vue;

import com.example.cholongtest.entity.Student;
import com.example.cholongtest.service.VueStudentService;
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
@RequestMapping("/vuestudent")
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueStudentController {

    @Autowired
    private VueStudentService service;

    @GetMapping("/scoreManagement")
    public ResponseEntity<List<Student>> getStudentScore () throws Exception {
        log.info("getStudentScore()");

        return new ResponseEntity<>(service.getStudentScoreList(), HttpStatus.OK);
    }
}
