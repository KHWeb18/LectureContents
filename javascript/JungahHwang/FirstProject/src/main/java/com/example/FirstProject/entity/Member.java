package com.example.FirstProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Member {
    private int idNo;
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String addr;
    private String gender;
    private String email;
    private String birth;
    private Date regDate;
}
