package com.example.jswithspring.service;

import com.example.jswithspring.entity.VueMember;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
    // public void login(VueMember member) throws Exception;
    // public List<VueMember> list() throws Exception;
}