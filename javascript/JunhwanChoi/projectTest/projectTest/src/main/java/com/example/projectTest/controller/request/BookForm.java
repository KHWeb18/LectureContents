package com.example.projectTest.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookForm {

    private String start;
    private String time;
    private String title;
    private String name;



    public BookRequest toBookRequest() {
        return new BookRequest(start, time, title, name);
    }
}