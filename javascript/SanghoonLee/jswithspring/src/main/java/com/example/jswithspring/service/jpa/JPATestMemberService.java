package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
import com.example.jswithspring.entity.jpa.TestMember;

import java.util.List;

public interface JPATestMemberService {

    public List<TestMember> findByJPQL() throws Exception;
    public List<Object[]> findSpecificByJPQL() throws Exception;
}
