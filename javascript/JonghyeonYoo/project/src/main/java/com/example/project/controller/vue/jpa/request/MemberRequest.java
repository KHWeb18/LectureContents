package com.example.project.controller.vue.jpa.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String email;
    private String auth;
}
