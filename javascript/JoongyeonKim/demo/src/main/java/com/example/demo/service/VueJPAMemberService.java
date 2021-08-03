package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.VueMember;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
    //public void login(Member member) throws Exception;
    //public List<VueMember> lists() throws Exception;
}
