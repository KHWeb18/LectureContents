package com.example.Quiz.service;

import com.example.Quiz.entity.Monster;
import com.example.Quiz.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {
    @Autowired
    private MonsterRepository repository;

    @Override
    public void create(Monster monster) throws Exception {
        repository.create(monster);
    }

    @Override
    public List<Monster> list() throws Exception {
        return repository.list();
    }

    @Override
    public Monster read(Integer monsterNo) throws Exception {
        return repository.read(monsterNo);
    }

    @Override
    public void modify(Monster monster) throws Exception {
        repository.update(monster);
    }

    @Override
    public void remove(Integer monsterNo) throws Exception {
        repository.delete(monsterNo);
    }
}
