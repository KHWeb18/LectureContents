package com.example.wonkimproj.service;


import com.example.wonkimproj.entity.Login;
import com.example.wonkimproj.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository repository;

    @Override
    public void login(Login login) throws Exception {
        repository.create(login);
    }
}
