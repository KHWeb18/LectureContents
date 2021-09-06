package com.example.projectTest.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Board {


    private int boardNo;
    private int age;
    private String gender;
    private String vaccine;
    private String content;
    private Date regDate;

   /* private int projectNo;
    private String name;
    private int price;
    private String description;
    private Date regDate;
*/
}
