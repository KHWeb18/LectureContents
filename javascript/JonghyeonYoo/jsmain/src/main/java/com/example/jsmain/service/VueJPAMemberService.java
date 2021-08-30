package com.example.jsmain.service;

import com.example.jsmain.entity.Member;
import com.example.jsmain.entity.VueMember;

import java.util.List;

public interface VueJPAMemberService {
     void register(VueMember member) throws Exception;
// public void login(VueMember member) throws Exception;
// public List<VueMember> list() throws Exception;
}