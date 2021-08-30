package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.service.RecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/recommend")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RecommendController {

    @Autowired
    private RecommendService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Validated @RequestBody Recommend recommend) throws Exception {
        log.info("Recommend Register");

        service.register(recommend);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Object[]>> lists() throws Exception {
        log.info("Recommend Lists");

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity<List<Object[]>> read(@PathVariable("boardNo") @RequestBody Long boardNo) throws Exception {
        log.info("read");

        return new ResponseEntity<List<Object[]>>(service.read(boardNo), HttpStatus.OK);
    }

    @PutMapping("/modify/{boardNo}")
    public ResponseEntity<Recommend> modify(@PathVariable("boardNo") Long boardNo,
                                       @Validated @RequestBody Recommend recommend) throws Exception {
        log.info("modify");

        recommend.setBoardNo(boardNo);

        service.modify(recommend);

        return new ResponseEntity<>(recommend, HttpStatus.OK);
    }

}






















