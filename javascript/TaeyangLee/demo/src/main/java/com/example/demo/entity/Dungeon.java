package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Dungeon {
    private int dungeonNo;
    private String name;
    private String description;
    private int monsterAmount ;
    private Date regDate;

}
