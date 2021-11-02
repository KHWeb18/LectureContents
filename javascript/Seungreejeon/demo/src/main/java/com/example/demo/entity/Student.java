package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class Student {
    private Integer studentNo;
    private String name;
    private String major;
    private Integer score;
    private Date reg_Date;
    private String grade;
}
