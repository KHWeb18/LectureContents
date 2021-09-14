package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.VueMember;

import java.util.List;


public interface VueJPAMemberService {
    void register(VueMember member) throws Exception;
    // public void login(VueMember member) throws Exception;
    // public List<VueMember> list() throws Exception;
}
