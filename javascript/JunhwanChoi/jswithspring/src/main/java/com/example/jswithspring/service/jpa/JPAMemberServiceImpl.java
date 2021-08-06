package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
import com.example.jswithspring.entity.jpa.JpaMember;
import com.example.jswithspring.entity.jpa.MemberAuth;
import com.example.jswithspring.repository.jpa.JPAMemberAuthRepository;
import com.example.jswithspring.repository.jpa.JPAMemberRepository;
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
        JpaMember JPAMemberEntity = new JpaMember(memberRequest.getUserId(), memberRequest.getPassword());
        JPAMemberEntity.addAuth(authEntity);

        memberRepository.save(JPAMemberEntity);
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