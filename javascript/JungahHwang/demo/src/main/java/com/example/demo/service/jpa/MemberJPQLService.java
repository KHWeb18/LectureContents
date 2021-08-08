package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberJPQL;

import java.util.List;

public interface MemberJPQLService {
    public List<MemberJPQL> findByJPQL() throws Exception;
    public List<Object[]> findSpecificJPQL() throws Exception;
}
