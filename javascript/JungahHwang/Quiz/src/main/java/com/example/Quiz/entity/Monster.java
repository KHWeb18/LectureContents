package com.example.Quiz.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Monster {
    private Integer monsterNo;
    private String name;
    private Integer hp;
    private Integer exp;
    private Integer money;
    private String item;
    private Date regDate;
}
