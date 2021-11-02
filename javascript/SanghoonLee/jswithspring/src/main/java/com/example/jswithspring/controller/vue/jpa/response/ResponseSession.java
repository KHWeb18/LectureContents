package com.example.jswithspring.controller.vue.jpa.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseSession {
    String email;
    String hashcode;

    public ResponseSession(String email, String hashcode) {
        this.email = email;
        this.hashcode = hashcode;
    }
}
