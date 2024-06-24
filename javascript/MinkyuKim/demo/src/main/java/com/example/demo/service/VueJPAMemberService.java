package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.VueMember;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
}