package com.example.demo.newcontroller.vue;

import com.example.demo.entity.Dungeon;
import com.example.demo.entity.Monster;
import com.example.demo.entity.Student;
import com.example.demo.service.VueDungeonService;
import com.example.demo.service.VueMonsterService;
import com.example.demo.service.VueStudentScorevice;
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
    private VueStudentScorevice service;

    @GetMapping("/scoreManagement")
    public ResponseEntity<List<Student>> getStudentScoreList () throws Exception {
        log.info("getLists()");

        return new ResponseEntity<>(service.getStudentScoreList(), HttpStatus.OK);
    }
}