package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class VueDungeon {
    private Integer dungeonNo;
    private String name;
    private String desc;
    private Integer monAmount;
    private Date regDate;

}
