package com.example.personalProject.service.jpa;

import com.example.personalProject.controller.jpa.request.MemberRequest;
import com.example.personalProject.eutity.jpa.Member;
import com.example.personalProject.eutity.jpa.MemberAuth;
import com.example.personalProject.repository.jpa.JPAMemberAuthRepository;
import com.example.personalProject.repository.jpa.JPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JPAMemberServiceImpl implements JPAMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());

        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw(),
                memberRequest.getName(),memberRequest.getSex(),
                memberRequest.getPhoneNo(),memberRequest.getBirth());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }
/*
    @Override
    public List<Member> list() throws Exception {
       return repository.list();
    }

    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }

    @Override
    public Member read(Integer memberNo) throws Exception {
        return repository.read(memberNo);
    }

    @Override
    public void remove(Integer memberNo) throws Exception {
        repository.delete(memberNo);
    }

    @Override
    public void modify(Member member) throws Exception {
        repository.update(member);
    }

    @Override
    public Member read(Integer boardNo) throws Exception {
        return repository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        repository.delete(boardNo);
    }
     */

    @Override
    public Optional <Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }
}