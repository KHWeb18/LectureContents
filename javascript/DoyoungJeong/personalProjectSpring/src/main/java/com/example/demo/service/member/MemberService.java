package com.example.demo.service.member;

import com.example.demo.controller.concert.request.ConcertDeleteRequest;
import com.example.demo.controller.concert.request.ConcertRequest;
import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.controller.member.response.MemberResponse;
import com.example.demo.entity.member.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberService {

    public boolean register(MemberRequest memberRequest) throws Exception;

    public Member login(MemberRequest memberRequest) throws Exception;

    public List<Member> getList() throws Exception;

    public Member read(Long memberNo) throws Exception;

    public void delete(Long memberNo) throws Exception;

    public MemberResponse modify(MemberRequest memberRequest) throws Exception;

    public boolean checkSessionValidation(String memberId) throws Exception;

    public void addLiked(ConcertRequest concertRequest) throws Exception;

    public boolean isNotAlreadyLiked(Long memberNo, Long concertNo) throws Exception;

    public void deleteLiked(ConcertDeleteRequest concertDeleteRequest) throws Exception;

    public boolean checkPassword(MemberRequest memberRequest) throws Exception;
}
