package com.example.cholongtest.controller.vue;

import com.example.cholongtest.entity.Board;
import com.example.cholongtest.entity.Monster;
import com.example.cholongtest.service.VueMonsterService;
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
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueMonsterController {

    @Autowired
    private VueMonsterService service;

    // Validated: 값이 올바르게 들어오는지 검증함
    // ResponseBody 가 붙어 있으면 리턴하는 값을 json 형식으로 만들어줌
    @PostMapping("/register")
    public ResponseEntity<Monster> register(@Validated @RequestBody Monster monster) throws Exception {
        log.info("post register request from vue");

        service.register(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Monster>> getLists () throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{monsterNo}")
    public ResponseEntity<Monster> read(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        Monster monster = service.read(monsterNo);

        return new ResponseEntity<Monster>(monster, HttpStatus.OK);
    }



    @PutMapping("/{monsterNo}")
    public ResponseEntity<Monster> modify(@PathVariable("monsterNo") Integer monsterNo,
                                        @Validated @RequestBody Monster monster ) throws Exception {
        monster.setMonsterNo(monsterNo);
        service.modify(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @DeleteMapping("/{monsterNo}")
    public ResponseEntity<Void> remove(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        service.remove(monsterNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
