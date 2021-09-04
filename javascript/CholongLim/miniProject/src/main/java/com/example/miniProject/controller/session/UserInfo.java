package com.example.miniProject.controller.session;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 일시적으로 갖고있는 정보
@Data
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    // 원래 userId 하나만 !
    private String userId;
    private String auth;

}