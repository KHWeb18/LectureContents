package com.example.wonkimproj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Register {
    private int userNo;
    private String id; // m_id
    private String pw; // m_pw
    private String name; // m_name
    private String addr; // m_addr
    private String addr2; // m_addr
    private String addr3; // u_addr3
    private String email; // m_email
    private String email2; // m_email
    private String pn; // m_pn
    private String pn2;
    private Date regDate;
}
