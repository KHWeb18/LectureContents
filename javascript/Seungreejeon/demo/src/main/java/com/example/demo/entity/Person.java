package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Person {
    private Integer studentNo;
    private String name;
    private Integer score;
    private Date regDate;
}

