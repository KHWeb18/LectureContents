package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.repository.jpa.JPAMemberAuthRepository;
import com.example.miniProject.repository.jpa.JPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class JPAMemberServiceImpl implements JPAMemberService {

    @Autowired
    private JPAMemberRepository memberRepository;

    @Autowired
    private JPAMemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Override
//    public void register(Member member) throws Exception {
//        // v 밑 두줄이 비밀번호 암호화에 사용된 코드
//
//
//        String encodedPassword = passwordEncoder.encode(member.getPassword());
//        member.setPassword(encodedPassword);
//
//        memberRepository.save(member);
//
//    }

    @Override
    public void register(Member member) throws Exception {
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        String encodedPasswordReInput = passwordEncoder.encode(member.getPasswordReInput());
        member.setPasswordReInput(encodedPasswordReInput);

        memberRepository.save(member);

    }

    @Override
    public boolean duplicateCheck(Member member) throws Exception {
        Optional<Member> checkMember = memberRepository.findByDuplicateCheck(member.getUserId());

        if (checkMember == null)
        {
            log.info("check(): Able");
            return true;
        }
        log.info("check(): Able");
        return false;
    }



    // 암호화 로그인
    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        // 아이디 매칭
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        Member loginMember = maybeMember.get();

        // 비밀번호 매칭
        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        // 모두 통과 시 로그인 성공
        return true;
    }

    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }
        return true;
    }



    /*
    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }
     */

}
