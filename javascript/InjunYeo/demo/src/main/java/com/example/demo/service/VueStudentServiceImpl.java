package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.VueStudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueStudentServiceImpl implements VueStudentService {

    @Autowired
    private VueStudentScoreRepository repository;



    @Override
    public List<Student> getStudentScoreList() throws Exception {
        return repository.getStudentScoreList();
    }
}
