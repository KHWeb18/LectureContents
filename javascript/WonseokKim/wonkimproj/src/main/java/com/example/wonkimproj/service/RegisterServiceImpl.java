package com.example.wonkimproj.service;

import com.example.wonkimproj.entity.Login;
import com.example.wonkimproj.entity.Register;
import com.example.wonkimproj.repository.LoginRepository;
import com.example.wonkimproj.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterRepository repository;

    @Override
    public void register(Register register) throws Exception {
        repository.create(register);
    }
    @Override
    public List<Register> list() throws Exception {
        return repository.list();
    }

    @Override
    public Register read(Integer userNo) throws Exception {
        return repository.read(userNo);
    }

    @Override
    public void remove(Integer userNo) throws Exception {
        repository.delete(userNo);
    }

    @Override
    public void modify(Register register) throws Exception {
        repository.update(register);
    }

/*    @Override
    public void idChk(Integer userNo) throws Exception {
        repository.update(userNo);
    }*/
}
