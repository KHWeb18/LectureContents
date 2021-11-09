// service 어떤 서비스인지

package com.example.cholongtest.service;
import com.example.cholongtest.entity.Member;

import java.util.List;

public interface VueMemberService {
    public void register(Member member) throws Exception;

    public void login(Member member) throws Exception;

    public List<Member> list() throws Exception;
}
