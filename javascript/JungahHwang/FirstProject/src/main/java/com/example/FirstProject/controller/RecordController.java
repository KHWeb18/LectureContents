package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Recommend;
import com.example.FirstProject.entity.Record;
import com.example.FirstProject.entity.Together;
import com.example.FirstProject.request.RecordDto;
import com.example.FirstProject.request.TogetherDto;
import com.example.FirstProject.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/record")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping("/add")
    public ResponseEntity<Void> register(@RequestBody RecordDto recordDto) throws Exception {
        log.info("Together Register");

        Record record = service.register(recordDto);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{date}")
    public ResponseEntity<Record> list(@PathVariable("date") @RequestBody String date) throws Exception {
        log.info("list" );

        Record record = service.findByDate(date);

        return new ResponseEntity<Record>(record, HttpStatus.OK);
    }

    @PatchMapping("/modify/{date}")
    public ResponseEntity<Void> modify(@PathVariable("date") String date,
                                         @RequestBody RecordDto recordDto) throws Exception {
        log.info("modify");

        Record record = service.findByDate(date);

        service.modify(record, recordDto);


        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{date}")
    public ResponseEntity<Void> remove(@PathVariable("date") String date) throws Exception {

        Record record = service.findByDate(date);

        service.remove(record);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}




















