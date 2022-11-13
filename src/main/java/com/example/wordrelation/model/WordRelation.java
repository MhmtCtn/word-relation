package com.example.wordrelation.model;

import com.example.wordrelation.model.enums.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
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

    @NotBlank(message = "Relation must not be empty!")
    @Enumerated(EnumType.STRING)
    private Relation relation;
}
