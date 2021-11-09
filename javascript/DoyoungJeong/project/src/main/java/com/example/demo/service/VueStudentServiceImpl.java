package com.example.demo.service;

import com.example.demo.entity.VueStudent;
import com.example.demo.repository.VueStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueStudentServiceImpl implements VueStudentService{

    @Autowired
    private VueStudentRepository repository;

    @Override
    public List<VueStudent> list() throws Exception {
        return repository.list();
    }
}
