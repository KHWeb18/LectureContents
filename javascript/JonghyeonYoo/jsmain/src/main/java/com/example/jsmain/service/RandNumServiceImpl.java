package com.example.jsmain.service;

import com.example.jsmain.entity.RandNumMessage;
import com.example.jsmain.repository.RandNumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandNumServiceImpl implements RandNumService{

    @Autowired
    private RandNumRepository repository;

    @Override
    public RandNumMessage getRandom() {
        return repository.getRandom();
    }
}
