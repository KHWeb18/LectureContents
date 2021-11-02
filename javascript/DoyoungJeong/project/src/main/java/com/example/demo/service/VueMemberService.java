package com.example.demo.service;


import com.example.demo.entity.VueMember;

import java.util.List;

public interface VueMemberService {
    public void register(VueMember member) throws Exception;
    public void login(VueMember member) throws Exception;
    public List<VueMember> list() throws Exception;
    public VueMember read(Integer memberNo) throws Exception;
    public void modify(VueMember member) throws Exception;
    public void remove(Integer member) throws Exception;
}