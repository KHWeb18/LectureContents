package com.example.demo.newcontroller.vue;

import com.example.demo.entity.Product;
import com.example.demo.entity.Quiz;
import com.example.demo.service.VueProductService;
import com.example.demo.service.VueQuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/vuequiz")
public class vueQuizController {
    @Autowired
    private VueQuizService service;
    @PostMapping("/register")
    public ResponseEntity<Quiz> registerProduct(@Validated @RequestBody Quiz quiz) throws Exception {
        log.info("post register request from vue");

        service.register(quiz);

        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

}
