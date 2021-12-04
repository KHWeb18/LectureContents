package com.example.FirstProject.request;

import com.example.FirstProject.entity.Member;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String pw;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String address;
    private Date regDate;
    private Date updDate;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .birth(birth)
                .email(email)
                .phone(phone)
                .address(address)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
