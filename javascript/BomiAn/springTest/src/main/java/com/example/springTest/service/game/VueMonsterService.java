package com.example.springTest.service.game;

import com.example.springTest.entity.game.Monster;

import java.util.List;

public interface VueMonsterService {
    public void register(Monster monster) throws Exception;
    public List<Monster> list() throws Exception;
    public Monster read(Integer monsterNo) throws Exception;
    public void remove(Integer monsterNo) throws Exception;
    public void modify(Monster monster) throws Exception;
}
