package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Monster {

    //제이슨 내부에서 써야하면 클래스타입을 써야한다.

    private Integer monsterNo;
    private String name;
    private String description;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;
    private String dropItem;
    private Date regDate;


}
