package com.example.demo.service.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import com.example.demo.repository.jpa.MemberAuthRepository;
import com.example.demo.repository.jpa.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw());
        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public Optional<Member> findByAuth(Long memberNo) throws Exception {
        return memberRepository.findByAuth(memberNo);
    }

    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember == null) {
            log.info("아이디를 확인해 주세요");
            return false;
        }
        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("비밀번호를 확인해 주세요");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUserIdValidation(String id) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(id);

        if (maybeMember == null) {
            log.info("회원 정보를 찾을 수 없음");

            return false;
        }

        return true;
    }
}


























