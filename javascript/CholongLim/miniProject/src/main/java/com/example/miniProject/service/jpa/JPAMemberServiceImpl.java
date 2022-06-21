package com.example.miniProject.service.jpa;

import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.controller.member.request.UserRequest;
import com.example.miniProject.entity.jpa.Board;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.MemberAuth;
import com.example.miniProject.entity.jpa.Room;
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

    // 회원가입 시 아이디 중복체크
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

        if (maybeMember.equals(Optional.empty()))
        {
            log.info("doesn't exist.");
            return false;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("wrong password");
            return false;
        }

        return true;
    }


    @Override
    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByDuplicateCheck(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }
        return true;
    }


    @Override
    public Member user(String userId) throws Exception {
        Optional<Member> userInfo =  memberRepository.findByUserInfo(userId);

        if(!userInfo.isPresent()){
            throw new IllegalStateException();
        }
        return userInfo.get();
    }


    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }

    @Override
    public Member userRead(Long memberNo) throws Exception{
        Optional<Member> userDetail = memberRepository.findById(memberNo);
        if(userDetail.isPresent()) {
            Member member = userDetail.get();
            memberRepository.save(member);

            return member;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void removeUser(Long memberNo) throws Exception {
        memberRepository.deleteById(memberNo);
    }
}
