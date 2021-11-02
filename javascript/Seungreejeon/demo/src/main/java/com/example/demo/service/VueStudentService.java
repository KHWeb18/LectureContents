package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface VueStudentService {
    public void register(Student student) throws Exception;

    public List<Student> list() throws Exception;
//
//    public Student read(Integer monsterNo) throws Exception;
//
//    public void remove(Integer monsterNo) throws Exception;
//
//    public void modify(Student monster) throws Exception;
}