package com.example.demo.service;

import com.example.demo.entity.VueTriangle;
import com.example.demo.repository.VueTriangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueTriagnleServiceImpl implements VueTriangleService{

    @Autowired
    VueTriangleRepository repository;

    @Override
    public int calcArea(VueTriangle triangle) throws Exception {
        return repository.area(triangle);
    }
}
