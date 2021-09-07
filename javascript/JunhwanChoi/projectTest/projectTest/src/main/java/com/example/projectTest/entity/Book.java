package com.example.projectTest.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Book {


    private int bookNo;
    private int month;
    private int day;
    private int time;
    private String place;
    private Date regDate;

}
