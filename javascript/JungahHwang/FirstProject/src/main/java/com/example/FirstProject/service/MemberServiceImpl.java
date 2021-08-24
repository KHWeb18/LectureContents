package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.repository.MemberRepository;
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
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signup(Member member) throws Exception {
        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);

        repository.save(member);
    }

    @Override
    public boolean login(Member member) throws Exception {
        Optional<Member> maybeMember = repository.findById(member.getId());

        if (maybeMember == null) {
            return  false;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(member.getPw(), loginMember.getPw())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validationId(String id) throws Exception {
        Optional<Member> maybeMember = repository.findById(id);

        if (maybeMember == null) {
            log.info("회원 정보 없음");

            return false;
        }
        log.info(String.valueOf(maybeMember.get()));
        return true;
    }

    @Override
    public Optional<Member> userInfo(String id) throws Exception {
        return repository.findById(id);
    }
}












