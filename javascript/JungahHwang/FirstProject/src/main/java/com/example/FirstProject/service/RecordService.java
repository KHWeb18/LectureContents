package com.example.FirstProject.service;

import com.example.FirstProject.entity.Record;
import com.example.FirstProject.request.RecordDto;

import java.util.List;

public interface RecordService {
    public Record register(RecordDto recordDto) throws Exception;
    public Record findByDate(String date) throws Exception;
    public List<Record> findAllRecord() throws Exception;
    public void modify(Record record, RecordDto recordDto) throws Exception;
    public void remove(Record record) throws Exception;
}
