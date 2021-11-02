package com.example.demo.newcontroller.vue;

import com.example.demo.entity.Board;
import com.example.demo.entity.NagetloningTest;
import com.example.demo.service.VueMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vuemember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueMemberController {

    @Autowired
    private VueMemberService service;

    @PostMapping("/register")
    public ResponseEntity<NagetloningTest> register(@Validated @RequestBody NagetloningTest nagetloningTest) throws Exception {
        log.info("post register request from vue");

        service.register(nagetloningTest);

        return new ResponseEntity<>(nagetloningTest, HttpStatus.OK);
    }

}