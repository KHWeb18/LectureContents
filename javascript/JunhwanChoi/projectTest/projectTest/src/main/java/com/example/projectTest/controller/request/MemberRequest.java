package com.example.projectTest.controller.request;

import com.example.projectTest.entity.Member;
import com.example.projectTest.entity.MemberAuth;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String auth;
}