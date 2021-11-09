package com.example.demo.service;

import com.example.demo.entity.Dungeon;
import com.example.demo.entity.Monster;

import java.util.List;

public interface VueDungeonService {
    //public void register(Dungeon dungeon);

    public List<Dungeon> randomList() throws Exception;


}
