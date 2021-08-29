package com.example.cholongtest.controller.vue.jpa.request;

import lombok.Getter;

@Getter
public class SaveUserRequest {

    private String userId;

    public SaveUserRequest(String userId) {
        this.userId = userId;
    }

    public SessionUser toSessionUser() {
        return new SessionUser(userId);
    }
}