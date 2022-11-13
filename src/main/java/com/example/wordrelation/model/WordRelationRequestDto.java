package com.example.wordrelation.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class WordRelationRequestDto {

    @NotBlank(message = "First Word must not be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Only characters from A to Z(both lower and uppercase) are allowed")
    private String firstWord;

    @NotBlank(message = "Second Word must not be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Only characters from A to Z(both lower and uppercase) are allowed")
    private String secondWord;

    @NotBlank(message = "Relation must not be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Only characters from A to Z(both lower and uppercase) are allowed")
    private String relation;
}
