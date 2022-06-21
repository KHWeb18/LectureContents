package com.example.demo.service.member;

import com.example.demo.controller.member.request.TasteRequest;
import com.example.demo.entity.member.MemberTaste;
import com.example.demo.repository.member.MemberTasteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class TasteServiceImple implements TasteService{

    @Autowired
    MemberTasteRepository memberTasteRepository;

    @Override
    public void addTaste(TasteRequest tasteRequest) throws Exception {

        String chosenGenres = tasteRequest.getChosenGenres().replaceAll("\\[", "").replaceAll("\\]","").
                replaceAll("\"", "");

        String chosenArtists = tasteRequest.getChosenArtists().replaceAll("\\[", "").replaceAll("\\]","").
                replaceAll("\"", "");

        MemberTaste memberTaste = new MemberTaste(chosenGenres, tasteRequest.getSpeedTaste(), tasteRequest.getAtmosphereTaste(), chosenArtists);
        memberTaste.setMemberNo(new Long(tasteRequest.getMemberNo()));

        memberTasteRepository.deleteDefault(new Long(tasteRequest.getMemberNo())); //굳이?
        memberTasteRepository.save(memberTaste);
    }

    @Override
    public boolean isDecidedOrNot(Integer memberNo) throws Exception {

        boolean isNotDecidedYet = memberTasteRepository.isTasteThatExists(new Long(memberNo)).isEmpty();

        if(isNotDecidedYet) {
            log.info("isNotDecidedYet(): " + isNotDecidedYet);
            return true;
        }
        log.info("isNotDecidedYet(): " + isNotDecidedYet);
        return false;
    }

    @Override
    public void updateTaste(TasteRequest tasteRequest) throws Exception {

//        String chosenGenres = tasteRequest.getChosenGenres().replace("[", "");
//        chosenGenres = chosenGenres.replace("]", "");
//        chosenGenres = chosenGenres.replace("\"", "");

        String chosenGenres = tasteRequest.getChosenGenres().replaceAll("\\[", "").replaceAll("\\]","").
                replaceAll("\"", "");

//        String chosenArtists = tasteRequest.getChosenArtists().replace("[", "");
//        chosenArtists = chosenArtists.replace("]", "");
//        chosenArtists = chosenArtists.replace("\"", "");

        String chosenArtists = tasteRequest.getChosenArtists().replaceAll("\\[", "").replaceAll("\\]","").
                replaceAll("\"", "");

        memberTasteRepository.updateTaste(chosenGenres, tasteRequest.getSpeedTaste(), tasteRequest.getAtmosphereTaste(), chosenArtists,
                new Long(tasteRequest.getMemberNo()));
    }

    @Override
    public Optional<MemberTaste> getTaste(Integer memberNo) throws Exception {

        Optional<MemberTaste> memberTaste = memberTasteRepository.isTasteThatExists(new Long(memberNo));

        return memberTaste;
    }
}
