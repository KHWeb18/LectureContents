package com.example.jsmain.service;

import com.example.jsmain.entity.Dungeon;
import com.example.jsmain.repository.VueDungeonRepository;
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