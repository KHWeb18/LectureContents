package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@ToString
@Slf4j
public class Area {
    private Integer height;
    private Integer width;


//    public float calcArea(Integer height, Integer width) throws Exception {
//        float area = (float) (height * width) / 2;
//        log.info("값" + area);
//
//        return area;
//    }
}
