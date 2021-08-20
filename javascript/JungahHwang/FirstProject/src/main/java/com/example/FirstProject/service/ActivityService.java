package com.example.FirstProject.service;

import com.example.FirstProject.entity.Activity;

import java.util.Optional;

public interface ActivityService {
    public void register(Activity activity) throws Exception;
    public Optional<Activity> findByDate(String date) throws Exception;
}
