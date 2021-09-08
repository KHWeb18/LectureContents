package com.example.projectTest.controller;

import com.example.projectTest.controller.request.BookForm;
import com.example.projectTest.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JPABookController {
    @Autowired
    private BookService service;


    @PostMapping("register")
    public ResponseEntity<Void> getRegister(@RequestBody BookForm form) throws Exception {
        service.register(form);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}