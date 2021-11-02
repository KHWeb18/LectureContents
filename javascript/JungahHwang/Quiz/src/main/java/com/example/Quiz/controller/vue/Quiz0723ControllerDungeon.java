package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.Dungeon;
import com.example.Quiz.service.DungeonService;
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
@RequestMapping("/vuedungeon")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Quiz0723ControllerDungeon {

    @Autowired
    private DungeonService service;

    @GetMapping("/randomAlloc")
    public ResponseEntity<List<Dungeon>> randomDungeonList () throws Exception {
        log.info("randomDungeonList()");

        return new ResponseEntity<>(service.randomList(), HttpStatus.OK);
    }
}
