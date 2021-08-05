package com.example.jswithspring.service.jpa;

import com.example.jswithspring.entity.jpa.Member;
import com.example.jswithspring.repository.jpa.JPAMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAMemberServiceImpl implements JPAMemberService {

    @Autowired
    private JPAMemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        repository.save(member);
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