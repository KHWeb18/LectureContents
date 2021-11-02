package com.example.demo.service;

import com.example.demo.entity.Dungeon;
import com.example.demo.entity.Monster;
import com.example.demo.repository.VueDungeonRepository;
import com.example.demo.repository.VueMonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueDungeonServiceImpl implements VueDungeonService {

    @Autowired
    private VueDungeonRepository repository;
    /*
    @Override
    public void register(Dungeon dungeon)   {
        repository.create(dungeon);
    }
    */
    @Override
    public List<Dungeon> randomList() throws Exception {
        return repository.randomList();
    }

    /*
    @Override
    public Dungeon read(Integer dungeonNo) throws Exception {
        return repository.read(dungeonNo);
    }

    @Override
    public void remove(Integer dungeonNo) throws Exception {
        repository.delete(dungeonNo);
    }

    @Override
    public void modify(Dungeon dungeon) throws Exception {
        repository.update(dungeon);
    }
    */
}
