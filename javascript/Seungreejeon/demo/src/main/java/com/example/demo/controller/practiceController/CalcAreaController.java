package com.example.demo.controller.practiceController;


import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/triangle")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class CalcAreaController {
    @Autowired
    AreaService service;

    @PostMapping("/calculate")
    public float calcArea2(@RequestBody Area area) throws Exception {
        log.info("calc triangle" + area);

        Integer height = area.getHeight();
        Integer width = area.getWidth();

        return service.calcArea(height, width);
    }


//    @PostMapping("/calculate")
//    public ResponseEntity<Float> calcArea(@RequestBody Area area) throws Exception {
//        log.info("calc triangle" + area);
//
//        Integer height = area.getHeight();
//        Integer width = area.getWidth();
//
//        return new ResponseEntity<Float>(service.calcArea(height, width), HttpStatus.OK);
//    }

//    @PostMapping("/calculate")
//    @ResponseBody
//    public float calcArea2(@RequestBody Area area) throws Exception {
//        log.info("calc triangle" + area);
//
//        Integer height = area.getHeight();
//        Integer width = area.getWidth();
//
//        return service.calcArea(height, width);
//    }
}
