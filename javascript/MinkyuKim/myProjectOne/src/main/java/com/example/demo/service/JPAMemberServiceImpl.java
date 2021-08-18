package com.example.demo.service;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.repository.JPAMemberAuthRepository;
import com.example.demo.repository.JPAMemberRepository;
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

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        // 암호화 작업
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);



        // Member에 세팅
        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(), memberRequest.getName(),
                                        memberRequest.getDateOfBirth(), memberRequest.getPhoneNumber(), memberRequest.getEmail(),
                                        memberRequest.getAddress(), memberRequest.getGender(), memberRequest.getDrawing(),
                                        memberRequest.getArticle(), memberRequest.getLargeArtwork());
        memberEntity.addAuth(authEntity);

        log.info("name(service) -" + memberRequest.getName());

        memberRepository.save(memberEntity);
    }
/*
    @Override
    public boolean login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        Member loginMember = maybeMember.get();

        //meber.getPassword는 입력한 것, loginMember.getPassword는 db정보를 가져와 매칭하는 것
        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword()))
        {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return false;
        }

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

    /* /* 관리자가 회원목록 볼때 사용하기 위함 List
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