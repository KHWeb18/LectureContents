package com.example.Quiz.service;

import com.example.Quiz.entity.Dungeon;
import com.example.Quiz.repository.DungeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DungeonServiceImpl implements DungeonService {
    @Autowired
    private DungeonRepository repository;

    @Override
    public List<Dungeon> randomList() throws Exception {
        return repository.randomList();
    }
}

