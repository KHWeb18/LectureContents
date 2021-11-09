package com.example.demo.entity;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
public class Quiz89 {

    private Integer triangleArea;
    private Integer triangleWidth;
    private Integer triangleHeight;

    public Quiz89() {
        this.triangleArea = this.triangleHeight * this.triangleWidth;

        log.info("CalcTriangleArea(): " + triangleArea);
    }
}
