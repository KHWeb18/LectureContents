package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;

// axios를 보낼 때 객체 하나만을 보낼 수 있어, 서버에서 따로 받기위하여 MemberRequest를 새로 생성함.
@Data
@Slf4j
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String name;
    private Integer dateOfBirth;
    private Integer phoneNumber;
    private String email;
    private String address;
    private String gender;
    private String drawing;
    private String article;
    private String largeArtwork;
    private String auth;
}


