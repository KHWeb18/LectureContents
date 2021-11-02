package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@ToString
public class Dungeon {
    private Integer dungeonNo;
    private String name;
    private String description;
    private Integer monsterAmount;
    private Date regDate;


}
