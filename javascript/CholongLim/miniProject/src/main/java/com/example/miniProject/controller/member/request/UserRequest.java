package com.example.miniProject.controller.member.request;


import com.example.miniProject.entity.jpa.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@Data
@Slf4j
@NoArgsConstructor
public class UserRequest {
    private String userId;
}



