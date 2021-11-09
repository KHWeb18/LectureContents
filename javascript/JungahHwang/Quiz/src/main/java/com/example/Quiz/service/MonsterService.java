package com.example.Quiz.service;

import com.example.Quiz.entity.Monster;

import java.util.List;

public interface MonsterService {
    public void create(Monster monster) throws Exception;
    public List<Monster> list() throws Exception;
    public Monster read(Integer monsterNo) throws Exception;
    public void modify(Monster monster) throws Exception;
    public void remove(Integer monsterNo) throws  Exception;
}
