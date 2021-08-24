package com.example.FirstProject.service;

import com.example.FirstProject.entity.Record;
import com.example.FirstProject.repository.RecordJPARepository;
import com.example.FirstProject.repository.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordJPARepository jpaRepository;

    @Autowired
    private RecordRepository repository;

    @Override
    public void add(Record record) throws Exception {
        jpaRepository.save(record);
    }

    @Override
    public List<Object[]> findByDate(String date) throws Exception {
        return jpaRepository.findByDate(date);
    }

    @Override
    public void modify(Record record) throws Exception {
        repository.modify(record);
    }

    @Override
    public void remove(String date) throws Exception {
        repository.remove(date);
    }
}














