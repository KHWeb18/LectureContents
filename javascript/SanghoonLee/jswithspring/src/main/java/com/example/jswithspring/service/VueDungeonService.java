package com.example.jswithspring.service;

import com.example.jswithspring.entity.Dungeon;
import com.example.jswithspring.entity.Monster;

import java.util.List;

public interface VueDungeonService {

    public List<Dungeon> randomList() throws Exception;
}
