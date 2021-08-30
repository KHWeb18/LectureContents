package com.example.jsmain.service.jpa;

import com.example.jsmain.controller.vue.jpa.request.MemberRequest;
import com.example.jsmain.entity.jpa.Member;
import com.example.jsmain.entity.jpa.MemberAuth;
import com.example.jsmain.repository.jpa.JPAMemberAuthRepository;
import com.example.jsmain.repository.jpa.JPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class JPAMemberServiceImpl implements JPAMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

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
    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }
}