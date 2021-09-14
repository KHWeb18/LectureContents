package com.example.demo.service.artistAuth;

import com.example.demo.controller.member.request.ApproveOrNotRequest;
import com.example.demo.controller.member.request.ArtistAuthRequest;
import com.example.demo.controller.member.response.ConcertRequestResponse;
import com.example.demo.entity.artistAuth.RequestReply;

import java.util.List;

public interface ConcertRequestService {

    public void regRequest(ArtistAuthRequest artistAuthRequest);

    public String getUserName(Integer memberNo);

    public List<ConcertRequestResponse> getConcertRequestList(Integer memberNo);

    public ConcertRequestResponse getConcertRequest(Integer concertRequestNo);

    public void approveOrNotRequest(ApproveOrNotRequest approveOrNotRequest);

    public void inputReply(RequestReply requestReply);

    //public String findRequestReply(Integer concertRequestNo);

    public void modifyConcertRequest(ArtistAuthRequest artistAuthRequest);

    public void deleteConcertRequest(Integer concertRequestNo);
}
