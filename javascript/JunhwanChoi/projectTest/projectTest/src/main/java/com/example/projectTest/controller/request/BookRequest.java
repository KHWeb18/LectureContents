package com.example.projectTest.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BookRequest {

    private String start;
    private String time;
    private String title;
    private String name;

    public BookRequest(String start,  String time, String title, String name) {
        this.start = start;
        this.time = time;
        this.title = title;
        this.name = name;
    }
}