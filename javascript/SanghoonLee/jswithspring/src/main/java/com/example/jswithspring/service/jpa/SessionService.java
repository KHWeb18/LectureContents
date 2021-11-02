package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.SaveUserRequest;
import com.example.jswithspring.controller.vue.jpa.request.SessionKey;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}