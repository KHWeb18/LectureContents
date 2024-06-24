package com.example.jsmain.service.jpa;

import com.example.jsmain.controller.vue.jpa.request.MemberRequest;
import com.example.jsmain.entity.jpa.Member;
import com.example.jsmain.entity.jpa.MemberAuth;
import com.example.jsmain.repository.jpa.JPAMemberAuthRepository;
import com.example.jsmain.repository.jpa.JPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAMemberServiceImpl implements JPAMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }
    /*
    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }

    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }

     */
}