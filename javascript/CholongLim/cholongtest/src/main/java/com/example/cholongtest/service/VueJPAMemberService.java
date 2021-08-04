package com.example.cholongtest.service;

import com.example.cholongtest.entity.DaumNews;
import com.example.cholongtest.entity.Member;
import com.example.cholongtest.entity.VueJPAMember;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface VueJPAMemberService {
    public void register(VueJPAMember member) throws Exception;
}
