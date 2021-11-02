package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Member {
    private int memberNo;
    private String id;
    private String pw;
    private String name;
    private int birthDay;
    private String address;
    private String party;
    private String comment;
    private Date regDate;
}
