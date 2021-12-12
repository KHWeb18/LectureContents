package com.example.projectTest.service;


import com.example.projectTest.controller.request.SignInForm;
import com.example.projectTest.entity.Account;

import com.example.projectTest.repository.JpaAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JpaAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(SignInForm form) throws Exception {
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        form.setPassword(encodedPassword);

        Account accountEntity = new Account(form.getName(), form.getBirth(), form.getEmail(), form.getPassword());

        accountRepository.save(accountEntity);
    }
}