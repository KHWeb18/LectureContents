package com.example.jswithspring.service;

import com.example.jswithspring.entity.Dungeon;
import com.example.jswithspring.entity.Student;

import java.util.List;

public interface VueStudentScoreService {

    public List<Student> getStudentScoreList() throws Exception;
}
