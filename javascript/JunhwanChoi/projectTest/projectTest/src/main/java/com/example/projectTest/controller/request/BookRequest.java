package com.example.projectTest.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BookRequest {

    private Integer month;
    private Integer day;
    private Integer time;
    private String place;

    public BookRequest(Integer month, Integer day, Integer time, String place) {
        this.month = month;
        this.day = day;
        this.time = time;
        this.place = place;
    }
}