package com.example.wordrelation.model;

import lombok.Data;

@Data
public class WordRelationRequestDto {

    private String firstWord;
    private String secondWord;
    private String relation;
}
