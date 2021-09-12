package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.request.RecommendDto;
import com.example.FirstProject.service.RecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/recommend")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RecommendController {

    @Autowired
    private RecommendService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RecommendDto recommendDto) throws Exception {
        log.info("Recommend Register");

        Recommend recommend = service.register(recommendDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Object[]>> lists() throws Exception {
        log.info("Recommend Lists");

        return new ResponseEntity<>(service.lists(), HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity<List<Object[]>> read(@PathVariable("boardNo") @RequestBody Long boardNo) throws Exception {
        log.info("Recommend Read");

        return new ResponseEntity<List<Object[]>>(service.read(boardNo), HttpStatus.OK);
    }

    @PatchMapping("/modify/{boardNo}")
    public ResponseEntity<Void> modify(@PathVariable("boardNo") Long boardNo,
                                       @RequestBody RecommendDto recommendDto) throws Exception {
        log.info("Recommend Modify");

        Recommend recommend = service.findByBoardNo(boardNo);

        service.modify(recommend, recommendDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("Recommend Remove");

        Recommend recommend = service.findByBoardNo(boardNo);

        service.remove(recommend);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/mapList")
    public ResponseEntity<List<Object[]>> mapList() throws Exception {
        log.info("Map List");

        return new ResponseEntity<>(service.mapList(), HttpStatus.OK);
    }

    @GetMapping("/userRead/{id}")
    public ResponseEntity userRead(@PathVariable("id") String id) throws Exception {
        log.info("Recommend UserRead");

        List<Recommend> recommends = service.userRead(id);

        return new ResponseEntity(recommends, HttpStatus.OK);
    }

}






















