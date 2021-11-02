package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.SignInForm;

public interface SignInService {

    Boolean signIn(SignInForm form);
}