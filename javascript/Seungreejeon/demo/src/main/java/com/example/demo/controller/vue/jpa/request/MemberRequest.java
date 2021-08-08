package com.example.demo.controller.vue.jpa.request;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
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