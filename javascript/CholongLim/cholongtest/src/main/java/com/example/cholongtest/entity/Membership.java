package com.example.cholongtest.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.crypto.Data;


@Getter
@Setter
@ToString
public class Membership {
    private Integer membershipNo;
    private String memName;
    private String memID;
    private String memPassword;
    private String phoneNum;
    private String memBirth;
    private Data regDate;
}
