package com.example.FirstProject.service;

import com.example.FirstProject.entity.Record;
import com.example.FirstProject.repository.RecordRepository;
import com.example.FirstProject.request.RecordDto;
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
    private RecordRepository repository;

    @Override
    public Record register(RecordDto recordDto) throws Exception {
        Record record = repository.save(recordDto.toEntity());

        return record;
    }

    @Override
    public Record findByDate(String date) throws Exception {
        Record record = repository.findByDate(date).orElse(null);

        return record;
    }

    @Override
    public List<Record> findAllRecord() throws Exception {
        List<Record> records = repository.findAll();

        return records;
    }

    @Override
    public void modify(Record record, RecordDto recordDto) throws Exception {
        record.updateRecord(recordDto);

        repository.save(record);
    }

    @Override
    public void remove(Record record) throws Exception {
        repository.delete(record);
    }
}














