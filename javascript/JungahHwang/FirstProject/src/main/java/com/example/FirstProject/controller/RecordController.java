package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Record;
import com.example.FirstProject.service.RecordService;
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
@RequestMapping("/record")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping("/add")
    public ResponseEntity<Void> register(@Validated @RequestBody Record record) throws Exception {
        log.info("add");

        service.add(record);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<Object[]>> list(@PathVariable("date") @RequestBody String date) throws Exception {
        log.info("list" + service.findByDate(date));

        List<Object[]> resultLists = service.findByDate(date);

        return new ResponseEntity<List<Object[]>>(resultLists, HttpStatus.OK);
    }

    @PutMapping("/modify/{date}")
    public ResponseEntity<Record> modify(@PathVariable("date") String date,
                                         @Validated @RequestBody Record record) throws Exception {
        log.info("modify");

        record.setDate(date);

        service.modify(record);

        return new ResponseEntity<>(record,HttpStatus.OK);
    }

    @DeleteMapping("/remove/{date}")
    public ResponseEntity<Void> remove(@PathVariable("date") String date) throws Exception {
        service.remove(date);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}




















