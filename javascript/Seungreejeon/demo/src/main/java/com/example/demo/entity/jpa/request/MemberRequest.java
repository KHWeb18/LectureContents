package com.example.demo.entity.jpa.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String auth;
}
