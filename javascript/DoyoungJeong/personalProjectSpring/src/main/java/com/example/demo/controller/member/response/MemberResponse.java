package com.example.demo.controller.member.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberResponse {

    private Long memberNo;
    private String id;
    private String identity;

    public MemberResponse(Long memberNo, String id, String identity) {
        this.memberNo = memberNo;
        this.id = id;
        this.identity = identity;
    }
}
