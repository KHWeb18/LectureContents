package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
import com.example.jswithspring.entity.jpa.Member;
import com.example.jswithspring.entity.jpa.MemberAuth;
import com.example.jswithspring.repository.jpa.JPAMemberAuthRepository;
import com.example.jswithspring.repository.jpa.JPAMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(
                memberRequest.getUserId(),
                memberRequest.getPassword());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) throws Exception {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth == null) {
            log.info("auth 없음");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(
                memberRequest.getUserId(),
                memberRequest.getPassword(),
                memberAuth.getAuth());

        return response;
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

    @Override
    public Optional<Member> findByAuth(Long memberNo) {
        return memberRepository.findByAuth(memberNo);
    }
}
