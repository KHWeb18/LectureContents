package com.example.cholongtest.service;

import com.example.cholongtest.entity.DaumNews;
import com.example.cholongtest.entity.Member;
import com.example.cholongtest.entity.VueJPAMember;
import com.example.cholongtest.repository.VueJPAMemberRepository;
import com.example.cholongtest.repository.VueMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class VueJPAMemberServiceImpl implements VueJPAMemberService {

    @Autowired
    private VueJPAMemberRepository repository;

    @Override
    public void register(VueJPAMember member) throws Exception {
        repository.save(member);
    }
}