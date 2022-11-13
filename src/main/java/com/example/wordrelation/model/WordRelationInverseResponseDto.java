package com.example.wordrelation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordRelationInverseResponseDto {

    private Long id;
    private String firstWord;
    private String secondWord;
    private String relation;
    private String yesOrNo;
}
