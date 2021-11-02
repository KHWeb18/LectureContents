package com.example.jswithspring.service;

import com.example.jswithspring.entity.Student;

import java.util.List;

public interface VueStudentService {

    public List<Student> getStudentScoreList() throws Exception;
}