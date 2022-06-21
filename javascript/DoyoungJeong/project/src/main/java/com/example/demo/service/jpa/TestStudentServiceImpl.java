package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.TestStudent;
import com.example.demo.repository.jpa.TestStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestStudentServiceImpl implements TestStudentService {

    @Autowired
    private TestStudentRepository repository;

    @Override
    public List<TestStudent> findByJPQL() throws Exception {
        return repository.findByJPQL("hihi");
    }

    @Override
    public List<Object[]> findSpecificByJPQL() throws Exception {
        return repository.findSpecificByJPQL("gogosing");
    }
}
