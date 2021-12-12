package com.example.projectTest.controller.request;

public enum SessionKey {
    SESSION_USER(SessionUser.class);

    private Class<?> clazz;

    public Class<?> getClazz() {
        return clazz;
    }

    SessionKey(Class clazz) {
        this.clazz = clazz;
    }
}