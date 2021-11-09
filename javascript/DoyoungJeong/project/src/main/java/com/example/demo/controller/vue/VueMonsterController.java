package com.example.demo.controller.vue;

import com.example.demo.entity.VueMonster;
import com.example.demo.service.VueMonsterService;
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

    @PostMapping("/upload")
    public ResponseEntity<VueMonster> upload(@Validated @RequestBody VueMonster monster) throws Exception{

        log.info(String.valueOf(monster));
        service.upload(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
        //여기서 리턴된 new monster객체는 어디로???
    }

    @GetMapping("/storage")
    public ResponseEntity<List<VueMonster>> getList() throws Exception {
        log.info("getLists(): " + service.list());

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{monsterNo}")
    public ResponseEntity<VueMonster> read(@PathVariable("monsterNo") Integer monsterNo) throws Exception {

        log.info("monsterNo: " + monsterNo);
        VueMonster monster = service.read(monsterNo);

        return new ResponseEntity<VueMonster>(monster, HttpStatus.OK);
    }

    @PutMapping("/{monsterNo}")
    //PutMapping???  클라이언트에서 axios.put으로 쐈으니 PutMapping으로 받아야한다!
    public ResponseEntity<VueMonster> modify(@PathVariable("monsterNo") Integer monsterNo, @Validated @RequestBody VueMonster monster) throws Exception {
        //@Validated @RequestBody Board board --> !클라이언트에서 전송된 title, content를 JSON의 형태인 board로 인자로 받겠다는 뜻이다!

        log.info("monsterModifyNo: " + monsterNo);
        log.info("getModify(): " + monster);

        monster.setMonsterNo(monsterNo);
        service.modify(monster);

        return new ResponseEntity<>(monster, HttpStatus.OK);
    }

    @DeleteMapping("/{monsterNo}")
    public ResponseEntity<Void> remove(@PathVariable("monsterNo") Integer monsterNo) throws Exception {
        service.remove(monsterNo);

        log.info("getRemove(): " + monsterNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
