
package com.example.projectTest.service;

import com.example.projectTest.controller.request.SaveUserRequest;
import com.example.projectTest.controller.request.SessionKey;

public interface SessionService {
    void save(SaveUserRequest request);
    void logout();
    // Object get(SessionKey key);
}