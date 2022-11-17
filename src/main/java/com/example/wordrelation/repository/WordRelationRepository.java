package com.example.wordrelation.repository;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.enums.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {

    List<WordRelation> findByRelationEquals(Relation relation);

    List<WordRelation> findByFirstWordEqualsIgnoreCase(String first);

    List<WordRelation> findByFirstWordEqualsAndSecondWordEquals(String first, String second);

    List<WordRelation> findByFirstWordEqualsAndRelationEquals(String first, Relation relation);
}
