package com.example.springTest.service.jpa;

import com.example.springTest.entity.jpa.TestMember;

import java.util.List;

public interface JPATestMemberService {

    public List<TestMember> findByJPQL() throws Exception;

    public List<Object[]> findSpecificByJPQL() throws Exception;
}