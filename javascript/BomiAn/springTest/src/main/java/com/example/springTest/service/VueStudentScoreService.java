package com.example.springTest.service;

import com.example.springTest.entity.Product;
import com.example.springTest.entity.Student;

import java.util.List;

public interface VueStudentScoreService {
    public List<Student> getStudentScoreList() throws Exception;
}
