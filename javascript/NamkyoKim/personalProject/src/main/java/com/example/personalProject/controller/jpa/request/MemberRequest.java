package com.example.personalProject.controller.jpa.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private String phoneNo;
    private String birth;
    private String auth;
}
