package com.example.jswithspring.controller.vue;

import com.example.jswithspring.entity.Dungeon;
import com.example.jswithspring.entity.Student;
import com.example.jswithspring.service.VueDungeonService;
import com.example.jswithspring.service.VueStudentService;
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
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueStudentController {

    @Autowired
    private VueStudentService service;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getRandomListsDungeon () throws Exception {
        log.info("getLists()");

        return new ResponseEntity<>(service.randomList(), HttpStatus.OK);
    }
}