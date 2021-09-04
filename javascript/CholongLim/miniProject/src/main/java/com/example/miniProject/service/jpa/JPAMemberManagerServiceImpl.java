package com.example.miniProject.service.jpa;


import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.entity.jpa.Member;

import com.example.miniProject.entity.jpa.MemberAuth;
import com.example.miniProject.repository.jpa.JPAMemberAuthRepository;
import com.example.miniProject.repository.jpa.JPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPAMemberManagerServiceImpl implements JPAMemberManagerService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;

    @Override
    public List<Member> list() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    public Member read(Long memberNo) throws Exception {
        Optional<Member> memberDetail = memberRepository.findById(memberNo);
        if(memberDetail.isPresent()) {
            Member member = memberDetail.get();
            memberRepository.save(member);

            return member;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void remove(Long memberNo) throws Exception {
        memberRepository.deleteById(memberNo);
    }

    //auth
    public List<MemberAuth> authList( ) throws Exception {
        return memberAuthRepository.findAll();
    }



}
