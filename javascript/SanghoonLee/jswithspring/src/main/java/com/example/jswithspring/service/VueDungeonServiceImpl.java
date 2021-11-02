package com.example.jswithspring.service;

import com.example.jswithspring.entity.Dungeon;
import com.example.jswithspring.entity.Monster;
import com.example.jswithspring.repository.VueDungeonRepository;
import com.example.jswithspring.repository.VueMonsterRepository;
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
