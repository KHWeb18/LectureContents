package com.example.cholongtest.service;

import com.example.cholongtest.entity.RandNumMessage;
import com.example.cholongtest.repository.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandNumServiceImpl implements RandNumService {

    @Autowired
    private RandomRepository repository;

    @Override
    public RandNumMessage getRandom() {
        return repository.getRandom();
    }
}
