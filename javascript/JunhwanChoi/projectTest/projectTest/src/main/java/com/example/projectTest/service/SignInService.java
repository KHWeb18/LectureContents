package com.example.projectTest.service;

import com.example.projectTest.controller.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}