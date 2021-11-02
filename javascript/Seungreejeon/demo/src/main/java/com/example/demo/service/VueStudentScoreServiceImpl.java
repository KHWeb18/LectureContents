package com.example.demo.service;


import com.example.demo.entity.Person;
import com.example.demo.repository.VuePersonRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueStudentScoreServiceImpl implements VueStudentScoreService{

    @Autowired
    VuePersonRepsitory repsitory;

    @Override
    public List<Person> getStudentScoreList() throws Exception {
        return repsitory.getStudentScoreList();
    }
}
