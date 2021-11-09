package com.example.jsmain.controller.vue;

import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.entity.Monster;
import com.example.jsmain.entity.Student;
import com.example.jsmain.service.VueDungeonService;
import com.example.jsmain.service.VueMonsterService;
import com.example.jsmain.service.VueStudentScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vuescore")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueStudentScoreController {

    @Autowired
    private VueStudentScoreService service;

    @GetMapping("/scoreManagement")
    public ResponseEntity<List<Student>> getStudentScore () throws Exception {
        log.info("getStudentScore()");

        return new ResponseEntity<>(service.getStudentScoreList(), HttpStatus.OK);
    }
}