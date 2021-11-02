package com.example.project1.service;

import com.example.project1.entity.Member;
import com.example.project1.entity.Product;

import java.util.List;

public interface SignUpService {
    public void signup(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public List<Member>  memberList() throws Exception;

}