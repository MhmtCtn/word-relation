package com.example.wordrelation.model;

import com.example.wordrelation.model.converter.RelationToStringConverter;
import com.example.wordrelation.model.enums.Relation;
import com.example.wordrelation.model.validator.EnumValuePattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "First Word must not be empty!")
    private String firstWord;

    @NotBlank(message = "Second Word must not be empty!")
    private String secondWord;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Relation relation;
}
