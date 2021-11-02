package com.example.demo.service;

import com.example.demo.eutity.Dungeon;
import com.example.demo.eutity.Student;
import com.example.demo.repository.VueDungeonRepository;
import com.example.demo.repository.VueStudentScoreRepository;
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