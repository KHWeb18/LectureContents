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

    private Integer month;
    private Integer day;
    private Integer time;
    private String place;



    public BookRequest toBookRequest() {
        return new BookRequest(month, day, time, place);
    }
}