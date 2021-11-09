package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@ToString
public class Monster {
    private Integer monsterNo;
    private String name;
    private String description;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;
    private String dropItem;
    private Date regDate;
}
