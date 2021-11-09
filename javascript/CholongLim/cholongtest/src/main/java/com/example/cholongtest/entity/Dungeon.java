package com.example.cholongtest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;

@ToString
@Getter
@Setter
public class Dungeon {
    private Integer dungeonNo;
    private String name;
    private String description;
    private Integer monster_amount;
    private Date regDate;
}
