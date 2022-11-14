package com.example.wordrelation.service;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.WordRelationInverseResponseDto;

import java.util.List;

public interface WordRelationService {

    WordRelation addNewWordRelation(WordRelation relation);

    List<WordRelationInverseResponseDto> findAllRelations(boolean includeInverse);

    List<WordRelation> findByRelation(String relation);

    String createRelationStr(String first, String second);
}
