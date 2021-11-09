package com.example.jsmain.service;

import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.entity.Student;

import java.util.List;


public interface VueStudentScoreService {

    public List<Student> getStudentScoreList() throws Exception;
}