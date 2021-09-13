package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Together;
import com.example.FirstProject.request.TogetherDto;
import com.example.FirstProject.service.TogetherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity register(@RequestBody TogetherDto togetherDto) throws Exception {
        log.info("Together Register");

        Together together = service.register(togetherDto);

        return new ResponseEntity(together, HttpStatus.OK);
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

    @PatchMapping("/modify/{boardNo}")
    public ResponseEntity<Void> modify(@PathVariable("boardNo") Long boardNo,
                                       @RequestBody TogetherDto togetherDto) throws Exception {
        log.info("Together Modify");

        Together together = service.findByBoardNo(boardNo);

        service.modify(together, togetherDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("Together Remove");

        Together together = service.findByBoardNo(boardNo);

        service.remove(together);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/userRead/{id}")
    public ResponseEntity userRead(@PathVariable("id") String id) throws Exception {
        log.info("Together UserRead");

        List<Together> togethers = service.userRead(id);

        return new ResponseEntity(togethers, HttpStatus.OK);
    }

}






















