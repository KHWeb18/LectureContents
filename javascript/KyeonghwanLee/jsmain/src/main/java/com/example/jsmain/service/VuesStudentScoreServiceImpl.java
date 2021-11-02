package com.example.jsmain.service;

import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.entity.Student;
import com.example.jsmain.repository.VueDungeonRepository;
import com.example.jsmain.repository.VueStudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VuesStudentScoreServiceImpl implements VueStudentScoreService {

    @Autowired
    private VueStudentScoreRepository repository;

    @Override
    public List<Student> getStudentScoreList() throws Exception {
        return repository.getStudentScoreList();
    }
}