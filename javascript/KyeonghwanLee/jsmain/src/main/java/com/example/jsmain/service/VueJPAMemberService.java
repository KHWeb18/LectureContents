package com.example.jsmain.service;

import com.example.jsmain.entity.DaumNews;
import com.example.jsmain.entity.VueMember;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueMember member) throws Exception;
    // public void login(VueMember member) throws Exception;
    // public List<VueMember> list() throws Exception;
}
