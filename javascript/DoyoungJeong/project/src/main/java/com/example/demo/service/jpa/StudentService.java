package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;

public interface StudentService {
    public void register(StudentRequest studentRequest) throws Exception;
}
