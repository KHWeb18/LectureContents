package com.example.demo.service;

import com.example.demo.entity.VueDungeon;
import com.example.demo.repository.VueDungeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VueDungeonServiceImpl implements VueDungeonService {

    @Autowired
    private VueDungeonRepository repository;

    @Override
    public List<VueDungeon> randomList() throws Exception {
        return repository.randomList();
    }
}
