package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.SaveUserRequest;
import com.example.jswithspring.controller.vue.jpa.request.SessionKey;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionServiceImpl implements SessionService {

    private final HttpSession session;

    public SessionServiceImpl(HttpSession session) {
        this.session = session;
    }

    @Override
    public void save(SaveUserRequest request) {
        set(SessionKey.SESSION_USER, request.toSessionUser());
    }

    @Override
    public void logout() {
        session.invalidate();
    }

    private void set(SessionKey key, Object obj) {
        session.setAttribute(key.name(), obj);
    }

    @SuppressWarnings("UNCHECKED_CAST")
    private Object get(SessionKey key) {
        return session.getAttribute(key.name());
    }
}