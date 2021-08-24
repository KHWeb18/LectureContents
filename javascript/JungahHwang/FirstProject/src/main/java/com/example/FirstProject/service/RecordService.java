package com.example.FirstProject.service;

import com.example.FirstProject.entity.Record;

import java.util.List;

public interface RecordService {
    public void add(Record record) throws Exception;
    public List<Object[]> findByDate(String date) throws Exception;
    public void modify(Record record) throws Exception;
    public void remove(String date) throws Exception;
}
