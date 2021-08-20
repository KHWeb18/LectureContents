package com.example.FirstProject.service;

import com.example.FirstProject.entity.Activity;
import com.example.FirstProject.repository.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Lazy
@Slf4j
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    private ActivityRepository repository;

    @Override
    public void register(Activity activity) throws Exception {
        repository.save(activity);
    }

    @Override
    public Optional<Activity> findByDate(String date) throws Exception {
        return repository.findByDate(date);
    }
}














