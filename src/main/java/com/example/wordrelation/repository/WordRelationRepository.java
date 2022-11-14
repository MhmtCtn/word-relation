package com.example.wordrelation.repository;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.enums.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {

    List<WordRelation> findByRelationEquals(Relation relation);

    List<WordRelation> findByFirstWordEqualsIgnoreCaseAndSecondWordEqualsIgnoreCase(String first, String second);

    List<WordRelation> findByFirstWordEqualsIgnoreCaseAndRelationEquals(String first, Relation relation);
}
