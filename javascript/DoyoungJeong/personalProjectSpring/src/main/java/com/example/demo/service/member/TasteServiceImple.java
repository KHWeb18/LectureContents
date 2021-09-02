package com.example.demo.service.member;

import com.example.demo.controller.member.request.TasteRequest;
import com.example.demo.entity.member.MemberTaste;
import com.example.demo.repository.member.MemberTasteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TasteServiceImple implements TasteService{

    @Autowired
    MemberTasteRepository memberTasteRepository;

    public void addTaste(TasteRequest tasteRequest) throws Exception {

        MemberTaste memberTaste = new MemberTaste(tasteRequest.getChosenGenres(), tasteRequest.getSpeedTaste(), tasteRequest.getAtmosphereTaste(),
                tasteRequest.getChosenArtists());
        memberTaste.setMemberNo(new Long(tasteRequest.getMemberNo()));

        memberTasteRepository.save(memberTaste);
    }
}
