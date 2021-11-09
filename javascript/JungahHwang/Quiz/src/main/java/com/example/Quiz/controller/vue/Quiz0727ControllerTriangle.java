package com.example.Quiz.controller.vue;

import com.example.Quiz.entity.Triangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Quiz0727ControllerTriangle {

    // json 형식의 데이터를 처리하려면 PostMapping을 이용하고 RequestBody를 붙여줘야 함
    @PostMapping("/calcTriangle")
    public double getCalcTriangle (@RequestBody Triangle triangle) {
        log.info("calcTriangle()");

        Integer width = triangle.getWidth();
        Integer height = triangle.getHeight();

        return width * height / 2.0;
    }
}
