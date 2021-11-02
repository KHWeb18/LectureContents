package com.example.springTest.entity.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Monster {
    private Integer monsterNo;
    private String monsterName;
    private Integer monsterHp;
    private Integer monsterExp;
    private Integer monsterMoney;
    private Date regDate;
}
