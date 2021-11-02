package com.example.demo.service;

import com.example.demo.entity.Dungeon;
import com.example.demo.entity.Product;
import com.example.demo.repository.VueDungeonRepository;
import com.example.demo.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueDungeonServiceImpl implements VueDungeonService {

    @Autowired
    private VueDungeonRepository repository;

    @Override
    public List<Dungeon> randomList() throws Exception {
        return repository.randomList();
    }
}