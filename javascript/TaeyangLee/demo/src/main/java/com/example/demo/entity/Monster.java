package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Monster {
    private Integer monsterNo;
    private String monster_name;
    private Integer monster_hp;

}