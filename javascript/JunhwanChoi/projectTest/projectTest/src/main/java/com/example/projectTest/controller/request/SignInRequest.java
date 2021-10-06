package com.example.projectTest.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SignInRequest {

    private String name;
    private Integer birth;
    private String email;
    private String password;

    public SignInRequest(String name, Integer birth, String email, String password) {
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.password = password;
    }
}