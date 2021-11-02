package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.VueMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service는 여기서 register가 여러방식으로동작할수 있음을 명시한다
//또한Controller가 Autowired에 자동으로 연결되도록 서포트 한다.

@Service
public class VueMemberServiceImpl implements VueMemberService {

    @Autowired
    private VueMemberRepository repository;



    @Override
    public void register(Member member) throws Exception {
        repository.create(member);
    }

    @Override
    public List<Member> list() throws Exception {
        return null;
    }
}
