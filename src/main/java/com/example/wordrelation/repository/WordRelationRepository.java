package com.example.wordrelation.repository;

import com.example.wordrelation.model.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {
}
