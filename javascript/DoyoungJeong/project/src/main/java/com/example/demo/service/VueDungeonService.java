package com.example.demo.service;

import com.example.demo.entity.VueDungeon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VueDungeonService {

    public List<VueDungeon> randomList() throws Exception;
}
