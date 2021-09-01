package com.example.miniProject.controller.member.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;



@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private Long memberNo;
    private String userId;
    private String password;
    private String passwordReInput;
    private String userName;
    private String userPhone;
    private String auth;
}