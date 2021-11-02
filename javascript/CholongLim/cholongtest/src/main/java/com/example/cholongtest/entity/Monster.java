package com.example.cholongtest.entity;
// entity 핵심 데이터 관리
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
    private String description;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;
    private String dropItem;
    private Date regDate;
}




