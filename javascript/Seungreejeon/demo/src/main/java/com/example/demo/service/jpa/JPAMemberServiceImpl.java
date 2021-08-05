package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import com.example.demo.entity.jpa.request.MemberRequest;
import com.example.demo.repository.jpa.JPAMemberAuthRepository;
import com.example.demo.repository.jpa.JPAMemberRepository;
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



//
//
//    @Override
//    public void register(Member member) throws Exception {
//        memberRepository.save(member);
//    }



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