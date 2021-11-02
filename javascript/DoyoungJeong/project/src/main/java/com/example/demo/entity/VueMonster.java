package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VueMonster {

    private Integer monsterNo;
    private String name;
    private Integer level;
    private Integer strength;
    private Integer hp;
    private String attribute;
    private Integer exp;

    //JSON사용을 위해 숫자 자료형은 Integer로 한다!

}
