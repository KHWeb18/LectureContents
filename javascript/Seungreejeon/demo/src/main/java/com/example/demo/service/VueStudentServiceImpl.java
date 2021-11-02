package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.VueMonsterRepository;
import com.example.demo.repository.VueStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueStudentServiceImpl implements VueStudentService {

    @Autowired
    private VueStudentRepository repository;

    @Override
    public void register(Student student) throws Exception {
        repository.create(student);
    }

    @Override
    public List<Student> list() throws Exception {
        return repository.list();
    }
//
//    @Override
//    public Monster read(Integer monsterNo) throws Exception {
//        return repository.read(monsterNo);
//    }
//
//    @Override
//    public void remove(Integer monsterNo) throws Exception {
//        repository.delete(monsterNo);
//    }
//
//    @Override
//    public void modify(Monster monster) throws Exception {
//        repository.update(monster);
//    }
}