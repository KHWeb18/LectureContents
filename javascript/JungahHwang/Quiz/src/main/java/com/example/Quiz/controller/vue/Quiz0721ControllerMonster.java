package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.Monster;
import com.example.Quiz.service.MonsterService;
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
public class Quiz0721ControllerMonster {

    @Autowired
    private MonsterService service;

    @PostMapping("/create")
    public ResponseEntity<Monster> create(@Validated @RequestBody Monster monster) throws Exception {
        log.info("/create monster");

        service.create(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Monster>> monsterLists() throws Exception {
        log.info("monsterLists()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{monsterNo}")
    public ResponseEntity<Monster> read(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        log.info("monsterRead()");

        Monster monster = service.read(monsterNo);

        return new ResponseEntity<Monster>(monster, HttpStatus.OK);
    }

    @PutMapping("/{monsterNo}")
    public ResponseEntity<Monster> modify(@PathVariable("monsterNo") Integer monsterNo,
                                        @Validated @RequestBody Monster monster) throws Exception{
        log.info("monsterModify()" + monster);

        monster.setMonsterNo(monsterNo);

        service.modify(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @DeleteMapping("/{monsterNo}")
    public ResponseEntity<Void> remove(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        log.info("monsterRemove");

        service.remove(monsterNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
