package com.example.jsmain.controller.vue;

import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.entity.Monster;
import com.example.jsmain.service.VueDungeonService;
import com.example.jsmain.service.VueMonsterService;
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