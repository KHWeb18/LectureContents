package com.example.demo.service.jpa;

import com.example.demo.controller.vue.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.TestMember;

import java.util.List;


public interface JPATestMemberService {

    List<TestMember> findByJPQL() throws Exception;
    List<Object[]> findSpecificByJPQL() throws Exception;

}