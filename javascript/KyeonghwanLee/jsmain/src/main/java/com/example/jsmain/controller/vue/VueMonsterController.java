package com.example.jsmain.controller.vue;

import com.example.jsmain.entity.Monster;
import com.example.jsmain.entity.Product;
import com.example.jsmain.service.VueMonsterService;
import com.example.jsmain.service.VueProductService;
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
@RequestMapping("/vuemonster")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueMonsterController {

    @Autowired
    private VueMonsterService service;

    @PostMapping("/register")
    public ResponseEntity<Monster> registerMonster(@Validated @RequestBody Monster monster) throws Exception {
        log.info("post register request from vue");

        service.register(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Monster>> getListsMonster () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{monsterNo}")
    public ResponseEntity<Monster> read(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        Monster monster = service.read(monsterNo);

        return new ResponseEntity<Monster>(monster, HttpStatus.OK);
    }

    @PutMapping("/{monsterNo}")
    public ResponseEntity<Monster> modifyMonster(@PathVariable("monsterNo") Integer monsterNo,
                                                 @Validated @RequestBody Monster monster) throws Exception {

        log.info("modifyMonster() - monsterNo: " + monsterNo);

        monster.setMonsterNo(monsterNo);

        log.info("modifyMonster(): " + monster);

        service.modify(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @DeleteMapping("/{monsterNo}")
    public ResponseEntity<Void> remove(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        service.remove(monsterNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}