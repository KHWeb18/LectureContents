package com.example.demo.service.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import com.example.demo.repository.jpa.MemberAuthRepository;
import com.example.demo.repository.jpa.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Lazy
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw());
        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public Optional<Member> findByAuth(Long memberNo) throws Exception {
        return memberRepository.findByAuth(memberNo);
    }
}


























