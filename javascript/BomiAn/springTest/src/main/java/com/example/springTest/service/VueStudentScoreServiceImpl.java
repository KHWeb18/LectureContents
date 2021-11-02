package com.example.springTest.service;

import com.example.springTest.entity.Product;
import com.example.springTest.entity.Student;
import com.example.springTest.repository.VueStudentScoreRepository;
import com.example.springTest.service.VueStudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueStudentScoreServiceImpl implements VueStudentScoreService {
    @Autowired
    private VueStudentScoreRepository repository;
    @Override
    public List<Student> getStudentScoreList() throws Exception {
        return repository.getStudentScoreList();
    }
}
