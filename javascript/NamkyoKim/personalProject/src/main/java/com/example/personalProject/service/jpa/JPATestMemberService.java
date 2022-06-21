package com.example.personalProject.service.jpa;

import com.example.personalProject.eutity.jpa.TestMember;

import java.util.List;
public interface JPATestMemberService {

    public List<TestMember> findByJPQL() throws Exception;

    public List<Object[]> findSpecificByJPQL() throws Exception;
}