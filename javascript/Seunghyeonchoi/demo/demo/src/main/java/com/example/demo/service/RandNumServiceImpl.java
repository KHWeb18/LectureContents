package com.example.demo.service;

import com.example.demo.entity.RandNumMessage;
import com.example.demo.repository.RandNumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandNumServiceImpl implements RandNumService {

    @Autowired
    private RandNumRepository repository;

    @Override
    public RandNumMessage getRandom() {
        return repository.getRandom();
    }
}