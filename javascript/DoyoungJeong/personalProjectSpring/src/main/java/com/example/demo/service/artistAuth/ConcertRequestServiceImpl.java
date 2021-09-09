package com.example.demo.service.artistAuth;

import com.example.demo.controller.member.request.ArtistAuthRequest;
import com.example.demo.controller.member.response.ConcertRequestResponse;
import com.example.demo.entity.artistAuth.ConcertRequest;
import com.example.demo.repository.artistAuth.ConcertRequestRepository;
import com.example.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ConcertRequestServiceImpl implements ConcertRequestService {

    @Autowired
    ConcertRequestRepository concertRequestRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void regRequest(ArtistAuthRequest artistAuthRequest) {

        Long memberNo = new Long(artistAuthRequest.getMemberNo());
        String timeOfConcert = artistAuthRequest.getTimeOfConcert() + " 부터 " + artistAuthRequest.getTimeOfEnd() + " 까지 ";

        ConcertRequest concertRequest = new ConcertRequest(memberNo, artistAuthRequest.getRegName(), artistAuthRequest.getArtistName(),
                artistAuthRequest.getVenueName(), artistAuthRequest.getConcertName(), artistAuthRequest.getDateOfConcert(), timeOfConcert);

        concertRequestRepository.save(concertRequest);
    }

    @Override
    public String getUserName(Integer memberNo) {

        String userName = memberRepository.findByMemberNo(new Long(memberNo)).get().getName();

        return userName;
    }

    @Override
    public List<ConcertRequestResponse> getConcertRequestList() {

        List<ConcertRequest> tmpConcertRequestList = concertRequestRepository.getList();
        //log.info("tmpConcertRequestList: " + tmpConcertRequestList);

        List<ConcertRequestResponse> concertRequestResponses = new ArrayList<>(Arrays.asList());
        ConcertRequestResponse concertRequestResponse;

        String dateOfCon;
        String regDate;

        SimpleDateFormat conDateFormat = new SimpleDateFormat("20yy년 MM월 dd일");
        SimpleDateFormat regDateFormat = new SimpleDateFormat("yy:MM:dd - hh:mm");

        for(int i=0; i< tmpConcertRequestList.size(); i++) {

            dateOfCon = conDateFormat.format(tmpConcertRequestList.get(i).getDateOfConcert());
            regDate = regDateFormat.format(tmpConcertRequestList.get(i).getRegDate());


            concertRequestResponse = new ConcertRequestResponse(tmpConcertRequestList.get(i).getConcertRequestNo(), tmpConcertRequestList.get(i).getRegName(), tmpConcertRequestList.get(i).getArtistName(),
                    tmpConcertRequestList.get(i).getVenueName(), tmpConcertRequestList.get(i).getConcertName(), dateOfCon,
                    tmpConcertRequestList.get(i).getTimeOfConcert(), tmpConcertRequestList.get(i).getApprovedOrNot(), regDate);
            //log.info("concertRequestResponse: " + concertRequestResponse);

            concertRequestResponses.add(concertRequestResponse);
        }
        //log.info("concertRequestResponses: " + concertRequestResponses);
        return concertRequestResponses;
    }

    @Override
    public void updateApproveOrNot(Integer concertRequestNo) {

        concertRequestRepository.updateApproveOrNot(new Long(concertRequestNo));
    }
}
