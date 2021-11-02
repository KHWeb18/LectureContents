package com.example.springTest.service.game;

import com.example.springTest.entity.game.Dungeon;
import com.example.springTest.repository.game.VueDungeonRepository;
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