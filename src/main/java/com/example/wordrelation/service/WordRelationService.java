package com.example.wordrelation.service;

import com.example.wordrelation.model.WordRelation;

import java.util.List;

public interface WordRelationService {

    WordRelation addNewWordRelation(WordRelation relation);

    List<WordRelation> findAllRelations();

    List<WordRelation> findByRelation(String relation);
}
