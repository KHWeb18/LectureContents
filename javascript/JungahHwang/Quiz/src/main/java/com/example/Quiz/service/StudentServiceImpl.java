package com.example.Quiz.service;

import com.example.Quiz.entity.Student;
import com.example.Quiz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> list() throws Exception {
        return repository.list();
    }
}
