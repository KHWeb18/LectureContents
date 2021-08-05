package com.example.demo.controller.vue.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;
import com.example.demo.service.jpa.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/joincolumntest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPAStudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/signup")
    public ResponseEntity<Void> jpaSignup(@Validated @RequestBody StudentRequest studentRequest) throws Exception {
        log.info("jpaSignup(): " + studentRequest.getStudentId() + ", " + studentRequest.getStudentPw() + ", " +
                studentRequest.getStudentGrade());

        service.register(studentRequest);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
