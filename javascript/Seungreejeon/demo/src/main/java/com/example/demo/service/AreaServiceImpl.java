package com.example.demo.service;


import com.example.demo.repository.AreaRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    AreaRepsitory repository;

    @Override
    public float calcArea(Integer height, Integer width) throws Exception {
        return repository.calc(height, width);
    }



}
