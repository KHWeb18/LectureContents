package com.example.demo.service.artistAuth;

import com.example.demo.controller.member.request.ApproveOrNotRequest;
import com.example.demo.controller.member.request.ArtistAuthRequest;
import com.example.demo.controller.member.response.ConcertRequestResponse;
import com.example.demo.entity.artistAuth.ConcertRequest;
import com.example.demo.entity.artistAuth.RequestReply;
import com.example.demo.repository.artistAuth.ConcertRequestRepository;
import com.example.demo.repository.artistAuth.RequestReplyRepository;
import com.example.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ConcertRequestServiceImpl implements ConcertRequestService {

    @Autowired
    ConcertRequestRepository concertRequestRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RequestReplyRepository requestReplyRepository;

    @Override
    public void regRequest(ArtistAuthRequest artistAuthRequest) {

        Long memberNo = new Long(artistAuthRequest.getMemberNo());
        String timeOfConcert = artistAuthRequest.getTimeOfConcert() + " 부터 " + artistAuthRequest.getTimeOfEnd() + " 까지 ";

        ConcertRequest concertRequest = new ConcertRequest(memberNo, artistAuthRequest.getRegName(), artistAuthRequest.getArtistName(),
                artistAuthRequest.getVenueName(), artistAuthRequest.getConcertName(), artistAuthRequest.getDateOfConcert(), timeOfConcert);

        RequestReply requestReply = new RequestReply("");
        concertRequest.addRequestReply(requestReply);

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
        SimpleDateFormat regDateFormat = new SimpleDateFormat("20yy-MM-dd hh:mm");

        for(int i=0; i< tmpConcertRequestList.size(); i++) {

            dateOfCon = conDateFormat.format(tmpConcertRequestList.get(i).getDateOfConcert());
            regDate = regDateFormat.format(tmpConcertRequestList.get(i).getRegDate());

            concertRequestResponse = new ConcertRequestResponse(tmpConcertRequestList.get(i).getConcertRequestNo(), tmpConcertRequestList.get(i).getRegName(),
                    tmpConcertRequestList.get(i).getArtistName(), tmpConcertRequestList.get(i).getVenueName(), tmpConcertRequestList.get(i).getConcertName(), dateOfCon,
                    tmpConcertRequestList.get(i).getTimeOfConcert(), tmpConcertRequestList.get(i).getApprovedOrNot(), regDate);
            //log.info("concertRequestResponse: " + concertRequestResponse);

            concertRequestResponses.add(concertRequestResponse);
        }
        //log.info("concertRequestResponses: " + concertRequestResponses);
        return concertRequestResponses;
    }

    @Override
    public ConcertRequestResponse getConcertRequest(Integer concertRequestNo) {

        Optional<ConcertRequest> tmpConcertRequest = concertRequestRepository.findByConcertRequestNo(new Long(concertRequestNo));

        SimpleDateFormat conDateFormat = new SimpleDateFormat("20yy년 MM월 dd일");
        SimpleDateFormat regDateFormat = new SimpleDateFormat("20yy-MM-dd hh:mm");

        String dateOfCon = conDateFormat.format(tmpConcertRequest.get().getDateOfConcert());
        String regDate = regDateFormat.format(tmpConcertRequest.get().getRegDate());

        ConcertRequestResponse concertRequestResponse = new ConcertRequestResponse(tmpConcertRequest.get().getConcertRequestNo(),
                tmpConcertRequest.get().getRegName(), tmpConcertRequest.get().getArtistName(),
                tmpConcertRequest.get().getVenueName(), tmpConcertRequest.get().getConcertName(), dateOfCon,
                tmpConcertRequest.get().getTimeOfConcert(), tmpConcertRequest.get().getApprovedOrNot(), regDate);

        //log.info("concertRequestResponse: " + concertRequestResponse);
        return concertRequestResponse;
    }

    @Override
    public void approveOrNotRequest(ApproveOrNotRequest approveOrNotRequest) {

        int concertRequestNo = approveOrNotRequest.getNumArr()[0];
        int statusNum = approveOrNotRequest.getNumArr()[1];

        if(statusNum == 1) {
            concertRequestRepository.approveConcertRequest(new Long(concertRequestNo));
        } else if(statusNum == 2) {
            concertRequestRepository.denyConcertRequest(new Long(concertRequestNo));
        } else if(statusNum == 3) {
            concertRequestRepository.deferConcertRequest(new Long(concertRequestNo));
        }
    }

    @Override
    public void inputReply(RequestReply requestReply) {

        Long concertRequestNo = requestReply.getConcertRequestNo();
        String replyContent = requestReply.getRequestReply();

        requestReplyRepository.saveReply(replyContent, concertRequestNo);
    }

    @Override
    public String findRequestReply(Integer concertRequestNo) {

        Optional<RequestReply> tmpRequestReply = requestReplyRepository.findByConcertRequestNo(new Long(concertRequestNo));
        String requestReply = tmpRequestReply.get().getRequestReply();

        return requestReply;
    }
}
