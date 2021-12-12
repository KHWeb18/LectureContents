package com.example.projectTest.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInForm {

    private String name;
    private Integer birth;
    private String email;
    private String password;

    public SignInRequest toSignInRequest() {
        return new SignInRequest(name, birth, email, password);
    }
}