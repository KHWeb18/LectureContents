package com.example.jswithspring.service;

import com.example.jswithspring.entity.Dungeon;
import com.example.jswithspring.entity.Student;
import com.example.jswithspring.repository.VueDungeonRepository;
import com.example.jswithspring.repository.VueStudentScoreRepository;
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
