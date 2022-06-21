package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.TestStudent;

import java.util.List;

public interface TestStudentService {

    public List<TestStudent> findByJPQL() throws Exception;
    public List<Object[]> findSpecificByJPQL() throws Exception;

}
