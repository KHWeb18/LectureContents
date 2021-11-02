package com.example.Quiz.service;

import com.example.Quiz.entity.Dungeon;

import java.util.List;

public interface DungeonService {
    public List<Dungeon> randomList() throws Exception;
}
