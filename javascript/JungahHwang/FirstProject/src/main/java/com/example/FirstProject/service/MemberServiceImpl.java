package com.example.FirstProject.service;

import com.example.FirstProject.entity.Member;
import com.example.FirstProject.repository.MemberRepository;
import com.example.FirstProject.request.MemberDto;
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

//    @Override
//    public void signup(Member member) throws Exception {
//        String encodedPassword = passwordEncoder.encode(member.getPw());
//        member.setPw(encodedPassword);
//
//        repository.save(member);
//    }
    @Override
    public Member signup(MemberDto memberDto) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberDto.getPw());
        memberDto.setPw(encodedPassword);

        Member member = repository.save(memberDto.toEntity());

        return member;
    }

    @Override
    public boolean login(Member member) throws Exception {
        Optional<Member> maybeMember = repository.findById(member.getId());

        if (maybeMember.isPresent()) {
            log.info("Find Id");

            Member loginMember = maybeMember.get();

            if(!passwordEncoder.matches(member.getPw(), loginMember.getPw())) {
                return false;
            }
        }

        return true;
    }

        //        Boolean isLogin = null;
//
//        if (maybeMember.isPresent()){
//            isLogin = false;
//        } else if(!maybeMember.isPresent()) {
//            Member loginMember = maybeMember.get();
//            if(passwordEncoder.matches(member.getPw(), loginMember.getPw())) {
//                isLogin = true;
//            } else if (!passwordEncoder.matches(member.getPw(), loginMember.getPw())) {
//                isLogin = false;
//            }
//        }
//        log.info(String.valueOf(isLogin));
//
//        return isLogin;


    @Override
    public boolean validationId(String id) throws Exception {
        Optional<Member> maybeMember = repository.findById(id);

        if (!maybeMember.isPresent()) {
            log.info("Not Find Id");

            return false;
        }

        return true;
    }

    @Override
    public Optional<Member> userInfo(String id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public Member findById(String id) throws Exception {
        Member member = repository.findById(id).orElseThrow();

        return member;
    }

    @Override
    public void modify(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberDto.getPw());
        memberDto.setPw(encodedPassword);

        member.updateMember(memberDto);

        repository.save(member);
    }

    @Override
    public void remove(Member member) throws Exception {
        repository.delete(member);
    }
}












