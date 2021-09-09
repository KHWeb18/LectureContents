package com.example.demo.service.artistAuth;

import com.example.demo.controller.member.request.ArtistAuthRequest;
import com.example.demo.controller.member.response.ConcertRequestResponse;

import java.util.List;

public interface ConcertRequestService {

    public void regRequest(ArtistAuthRequest artistAuthRequest);

    public String getUserName(Integer memberNo);

    public List<ConcertRequestResponse> getConcertRequestList();

    public void updateApproveOrNot(Integer concertRequestNo);
}
