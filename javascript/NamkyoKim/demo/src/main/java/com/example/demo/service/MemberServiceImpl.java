package com.example.demo.service;
import com.example.demo.eutity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시함
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void join(Member member) throws Exception {
        repository.create(member);
    }

    @Override
    public List<Member> list() throws Exception {
       return repository.list();
    }

    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }

    @Override
    public Member read(Integer memberNo) throws Exception {
        return repository.read(memberNo);
    }

    @Override
    public void remove(Integer memberNo) throws Exception {
        repository.delete(memberNo);
    }

    @Override
    public void modify(Member member) throws Exception {
        repository.update(member);
    }
/*

    @Override
    public Member read(Integer boardNo) throws Exception {
        return repository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        repository.delete(boardNo);
    }
     */
}