package com.example.demo.service;

import com.example.demo.entity.VueMember;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
    //public void login(Member member) throws Exception;
    public List<VueMember> lists() throws Exception;
}
