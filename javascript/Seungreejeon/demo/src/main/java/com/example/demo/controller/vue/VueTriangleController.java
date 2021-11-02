package com.example.demo.controller.vue;


import com.example.demo.entity.Triangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueTriangleController {

    @PostMapping("/calcTriangle")
    public double getCalcTriangle(@RequestBody Triangle triangle) {
        log.info("getCalcTriangle()" + triangle);

        Integer width = triangle.getWidth();
        Integer height = triangle.getHeight();


        return height * width / 2.0;
    }
}

