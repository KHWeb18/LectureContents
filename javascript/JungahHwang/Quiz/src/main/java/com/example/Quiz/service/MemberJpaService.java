package com.example.Quiz.service;

import com.example.Quiz.entity.MemberJpa;
import org.jsoup.nodes.Document;

public interface MemberJpaService {
    public void signup(MemberJpa member) throws Exception;
}
