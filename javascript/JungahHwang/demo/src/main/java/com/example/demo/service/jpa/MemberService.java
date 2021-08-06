package com.example.demo.service.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;

public interface MemberService {
    public void register(MemberRequest memberRequest) throws Exception;
}
