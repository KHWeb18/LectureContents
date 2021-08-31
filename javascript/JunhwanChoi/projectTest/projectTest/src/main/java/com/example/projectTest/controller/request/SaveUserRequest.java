package com.example.projectTest.controller.request;

import lombok.Getter;

@Getter
public class SaveUserRequest {

    private String email;

    public SaveUserRequest(String email) {
        this.email = email;
    }

    public SessionUser toSessionUser() {
        return new SessionUser(email);
    }
}