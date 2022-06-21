package com.example.demo.controller.vue.jpa.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String UserId;
    private String password;
    private String auth;
}
