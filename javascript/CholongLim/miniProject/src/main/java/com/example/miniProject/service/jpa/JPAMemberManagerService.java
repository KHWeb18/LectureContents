package com.example.miniProject.service.jpa;
import com.example.miniProject.controller.member.request.MemberRequest;
import com.example.miniProject.entity.jpa.Member;
import com.example.miniProject.entity.jpa.MemberAuth;

import java.util.List;
public interface JPAMemberManagerService {


    public List<Member> list( ) throws Exception;

    public Member read(Long memberNo) throws Exception;

    public void remove(Long memberNo) throws Exception;

    //auth
    public List<MemberAuth> authList( ) throws Exception;

}