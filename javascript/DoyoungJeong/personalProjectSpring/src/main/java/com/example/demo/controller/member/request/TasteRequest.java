package com.example.demo.controller.member.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TasteRequest {

    private Integer memberNo;
    private String chosenGenres;
    private String speedTaste;
    private String atmosphereTaste;
    private String chosenArtists;
}
