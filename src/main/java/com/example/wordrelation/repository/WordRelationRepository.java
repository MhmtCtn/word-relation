package com.example.wordrelation.repository;

import com.example.wordrelation.model.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {

    List<WordRelation> findByRelationEqualsIgnoreCase(String relation);

    List<WordRelation> findByFirstWordEqualsIgnoreCaseAndSecondWordEqualsIgnoreCase(String first, String second);
}
