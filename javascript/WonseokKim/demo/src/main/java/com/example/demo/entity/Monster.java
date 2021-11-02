package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Monster {
    private int monsterNo;
    // th:field로 맵핑됨
    private String monster_name;
    private int monster_hp;
    private int monster_exp;
    private String monster_description;
    private Date regDate;
    private int monster_money;
}
