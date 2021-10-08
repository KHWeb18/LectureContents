package com.example.demo.controller.vue.jpa.request;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
// axios를 보낼 때 객체 하나만을 보낼 수 있어, 서버에서 따로 받기위하여 MemberRequest를 새로 생성함.
@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String auth;
}