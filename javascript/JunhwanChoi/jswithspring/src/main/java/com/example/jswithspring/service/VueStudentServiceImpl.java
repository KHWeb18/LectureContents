package com.example.jswithspring.service;

import com.example.jswithspring.entity.Student;
import com.example.jswithspring.repository.VueStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueStudentServiceImpl implements VueStudentService {

    @Autowired
    private VueStudentRepository repository;

    @Override
    public List<Student> getStudentScoreList() throws Exception {
        return repository.getStudentScoreList();
    }
}