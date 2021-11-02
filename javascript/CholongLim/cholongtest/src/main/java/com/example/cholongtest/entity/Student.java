package com.example.cholongtest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Student {
    private Integer studentNo;
    private String name;
    private Integer grade;
    private Date regDate;
}
