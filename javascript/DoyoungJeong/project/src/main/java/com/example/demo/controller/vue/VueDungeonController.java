package com.example.demo.controller.vue;

import com.example.demo.entity.VueDungeon;
import com.example.demo.service.VueDungeonService;
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
    private VueDungeonService service; //여기 service에서 @service를 안넣어서 몇 시간동안 에러를 찾았다 ㅅㅂ ㅋㅋ

    @GetMapping("/list")
    public ResponseEntity<List<VueDungeon>> getRandomListsDungeon () throws Exception {
        log.info("getLists()");

        return new ResponseEntity<>(service.randomList(), HttpStatus.OK);
    }


}
