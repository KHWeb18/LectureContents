package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Together;
import com.example.FirstProject.service.TogetherService;
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
@RequestMapping("/together")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TogetherController {

    @Autowired
    private TogetherService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Validated @RequestBody Together together) throws Exception {
        log.info("Together Register");

        service.register(together);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Object[]>> lists() throws Exception {
        log.info("Together Lists");

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity<List<Object[]>> read(@PathVariable("boardNo") @RequestBody Long boardNo) throws Exception {
        log.info("Together Read");

        return new ResponseEntity<List<Object[]>>(service.read(boardNo), HttpStatus.OK);
    }

    @PutMapping("/modify/{boardNo}")
    public ResponseEntity<Together> modify(@PathVariable("boardNo") Long boardNo,
                                       @Validated @RequestBody Together together) throws Exception {
        log.info("Together Modify");

        together.setBoardNo(boardNo);

        service.modify(together);

        return new ResponseEntity<>(together, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("Together Remove");

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}






















