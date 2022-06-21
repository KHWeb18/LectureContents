package com.example.demo.service.member;

import com.example.demo.controller.member.request.TasteRequest;
import com.example.demo.entity.member.MemberTaste;

import java.util.Optional;

public interface TasteService {

    public void addTaste(TasteRequest tasteRequest) throws Exception;

    public void updateTaste(TasteRequest tasteRequest) throws Exception;

    public boolean isDecidedOrNot(Integer memberNo) throws Exception;

    public Optional<MemberTaste> getTaste(Integer memberNo) throws Exception;
}
