package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.StudentRequest;
import com.example.demo.entity.jpa.Student;

import java.util.Optional;

public interface StudentService {
    public void register(StudentRequest studentRequest) throws Exception;

    public Optional<Student> findByStudentNo(Long studentNo);

    public boolean login(StudentRequest studentRequest) throws Exception;

    public boolean checkStudentIdValidation(String studentId) throws Exception;

}
