package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Map;
import com.example.FirstProject.entity.Record;
import com.example.FirstProject.request.MapDto;
import com.example.FirstProject.request.RecordDto;
import com.example.FirstProject.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/map")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MapController {

    @Autowired
    MapService service;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody MapDto mapDto) throws Exception {
        log.info("Map Add");

        Map map = service.add(mapDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity read(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("Map Read");

        Map map = service.read(boardNo);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Map>> list() throws Exception {
        log.info("Map List");

        List<Map> maps = service.list();

        return new ResponseEntity<List<Map>>(maps, HttpStatus.OK);
    }

    @PatchMapping("/modify/{boardNo}")
    public ResponseEntity<Void> modify(@PathVariable("boardNo") Long boardNo,
                                       @RequestBody MapDto mapDto) throws Exception {
        log.info("Map Modify");

        Map map = service.read(boardNo);

        service.modify(map, mapDto);


        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("Map Remove");

        Map map = service.read(boardNo);

        service.remove(map);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
