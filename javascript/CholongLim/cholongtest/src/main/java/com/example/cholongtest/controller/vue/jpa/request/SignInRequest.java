package com.example.cholongtest.controller.vue.jpa.request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SignInRequest {

    private String userId;
    private String password;

    public SignInRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}