package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.request.MemberRequest;

public interface JPAMemberService {
    public void register(MemberRequest MemberRequest) throws Exception;

}
