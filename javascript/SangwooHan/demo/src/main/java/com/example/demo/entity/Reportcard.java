package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Reportcard {

    private String reportcardNo;
    private String name;
    private int score;
    private Date regDate;

}
