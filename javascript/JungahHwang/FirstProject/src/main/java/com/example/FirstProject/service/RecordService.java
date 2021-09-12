package com.example.FirstProject.service;

import com.example.FirstProject.entity.Record;
import com.example.FirstProject.request.RecordDto;

import java.util.List;

public interface RecordService {
    Record register(RecordDto recordDto) throws Exception;
    Record findByDate(String date) throws Exception;
    List<Record> findAllRecord() throws Exception;
    void modify(Record record, RecordDto recordDto) throws Exception;
    void remove(Record record) throws Exception;
}
