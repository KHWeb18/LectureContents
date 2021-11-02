package com.example.cholongtest.controller.vue;

import com.example.cholongtest.entity.Dungeon;
import com.example.cholongtest.entity.Monster;
import com.example.cholongtest.service.VueDungeonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vuedungeon")
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueDungeonController {

    @Autowired
    private VueDungeonService service;

    @GetMapping("/randomAlloc")
    public ResponseEntity<List<Dungeon>> getLists () throws Exception {
        log.info("getLists()");

        return new ResponseEntity<>(service.randomList(), HttpStatus.OK);
    }
}
