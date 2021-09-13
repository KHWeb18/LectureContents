package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Map;
import com.example.FirstProject.request.MapDto;
import com.example.FirstProject.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/map")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MapController {

    @Autowired
    MapService service;

    @GetMapping("/add")
    public ResponseEntity add(MapDto mapDto) throws Exception {
        Map map = service.add(mapDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/read/{boardNo}")
    public ResponseEntity<Optional<Map>> read(@PathVariable("boardNo") Long boardNo) throws Exception {
        Optional<Map> map = service.read(boardNo);

        return new ResponseEntity<Optional<Map>>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Map>> list() throws Exception {
        List<Map> maps = service.list();

        return new ResponseEntity<List<Map>>(maps, HttpStatus.OK);
    }
}
