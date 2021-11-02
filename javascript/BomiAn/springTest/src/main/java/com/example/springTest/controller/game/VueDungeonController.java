package com.example.springTest.controller.game;

import com.example.springTest.entity.game.Dungeon;
import com.example.springTest.service.game.VueDungeonService;
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
public class VueDungeonController {

    @Autowired
    private VueDungeonService service;

    @GetMapping("/randomAlloc")
    public ResponseEntity<List<Dungeon>> getRandomListsDungeon () throws Exception {
        log.info("getLists()");

        return new ResponseEntity<>(service.randomList(), HttpStatus.OK);
    }
}