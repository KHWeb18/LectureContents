package com.example.demo.controller.member.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberRequest {
    private Integer memberNo;
    private String id;
    private String password;
    private String name;
    private String location; // []로 고쳐야함
    private Date birthDay;
    private String identity;
    private String phoneNo;
}
