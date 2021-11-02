package com.example.demo.controller;

import com.example.demo.entity.VueTriangle;
import com.example.demo.service.VueTriangleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TestController {

    @Autowired
    VueTriangleService service;

    @GetMapping("/testController")
    public String testController() {
        log.info("testController()");

        return "/test/test";
    }

    @ResponseBody //왜 갑자기 얘가 붙어주어야한다는건가??? RequestBody가 클라이언트에서 서버로 보내는건데.. 해왔던 컨트롤러에선 지금까지 없어도 잘 됐던것같은데
    @PostMapping("/triangleArea")
    public int calcTriangleArea(@Validated @RequestBody VueTriangle triangle) throws Exception {
        log.info("calcTriangleArea()");

        log.info("triangle: " + triangle); //얘는 왜 콘솔창에 출력이 안될까?

        Integer width = triangle.getWidthSpring();
        Integer height = triangle.getHeightSpring();

        log.info(String.valueOf(triangle.getWidthSpring()));
        log.info(String.valueOf(triangle.getHeightSpring()));

        Integer areaValue = (width * height) / 2;
        log.info(String.valueOf(areaValue));

        return service.calcArea(triangle);
    }
}
