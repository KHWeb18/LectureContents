package com.example.cholongtest.service.jpa;

import com.example.cholongtest.controller.vue.jpa.request.MemberRequest;
import com.example.cholongtest.entity.jpa.Member;
import com.example.cholongtest.entity.jpa.MemberAuth;
import com.example.cholongtest.repository.jpa.JPAMemberAuthRepository;
import com.example.cholongtest.repository.jpa.JPAMemberRepository;
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

