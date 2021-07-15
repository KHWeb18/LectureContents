package com.example.jswithspring.service;

import com.example.jswithspring.entity.RandNumMessage;
import com.example.jswithspring.repository.RandNumRepository;
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