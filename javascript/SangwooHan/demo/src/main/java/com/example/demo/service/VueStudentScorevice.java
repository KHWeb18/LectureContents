package com.example.demo.service;

import com.example.demo.entity.Dungeon;
import com.example.demo.entity.Student;

import java.util.List;

public interface VueStudentScorevice {

    public List<Student> getStudentScoreList() throws Exception;
}