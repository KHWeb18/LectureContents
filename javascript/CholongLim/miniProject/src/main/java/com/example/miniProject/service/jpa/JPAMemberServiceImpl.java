package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.controller.member.request.UserRequest;
import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.MemberAuth;
import com.example.miniProject.repository.jpa.JPAMemberAuthRepository;
import com.example.miniProject.repository.jpa.JPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);
        String encodedPasswordReInput = passwordEncoder.encode(memberRequest.getPasswordReInput());
        memberRequest.setPasswordReInput(encodedPasswordReInput);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(),
                memberRequest.getPasswordReInput(),memberRequest.getUserName(),memberRequest.getUserPhone());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

    }

    @Override
    public boolean duplicateCheck(MemberRequest memberRequest) throws Exception {
        Optional<Member> checkMember = memberRepository.findByDuplicateCheck(memberRequest.getUserId());
        if (checkMember.isPresent()) {
            log.info("already exist");
            return false;
        } else {
            return true;
        }


    }



    // 암호화 로그인
    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        // 아이디 매칭
//        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());
        Optional<Member> maybeMember = memberRepository.findByDuplicateCheck(memberRequest.getUserId());

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

        return true;
    }

    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByDuplicateCheck(userId);
//        Optional<Member> maybeMember = memberRepository.findByUserId(userId);


        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }
        return true;
    }




//    @Override
//    public Member read(String userId) throws Exception {
//        Optional<Member> memberDetail = memberRepository.findByUserInfo(userId);
//        if(memberDetail.isPresent()) {
//            Member member = memberDetail.get();
//            memberRepository.save(member);
//
//            return member;
//        } else {
//            throw new NullPointerException();
//        }
//
//    }

    @Override
    public List<Member> list() throws Exception {
//        return memberRepository.findByUserInfo(userId);

        return memberRepository.findAll();
    }


    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }

}
