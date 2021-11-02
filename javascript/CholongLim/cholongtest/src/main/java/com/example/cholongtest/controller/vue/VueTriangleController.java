package com.example.cholongtest.controller.vue;

import com.example.cholongtest.entity.Triangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//데이터를 json 으로 파싱한다 = post 처럼 동작시킨다
@CrossOrigin(origins = "http://localHost:8080", allowedHeaders = "*")
public class VueTriangleController {

    // 근래 엄중성이 부여되어 RestController를 사용하더라도
    // JSON 방식의 데이터를 처리하려면 PostMapping에
    // 파라미터(입력)에 RequestBody를 붙여서 JSON임을 명시해주는 것이 좋다.

    // ResponseBody 가 붙어 있으면 리턴하는 값을 json 형식으로 만들어줌

    @PostMapping("/calcTriangle")
    public double getCalcTriangle (@RequestBody Triangle triangle) {
        log.info("getCalcTriangle(): " + triangle);

        Float width = triangle.getWidth();
        Float height = triangle.getHeight();

        return height * width / 2.0;
    }
}
