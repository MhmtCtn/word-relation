package com.example.wordrelation.service.impl;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.repository.WordRelationRepository;
import com.example.wordrelation.service.WordRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WordRelationServiceImpl implements WordRelationService {

    private WordRelationRepository wordRelationRepository;

    @Override
    public WordRelation addNewWordRelation(WordRelation relation) {
        return wordRelationRepository.save(relation);
    }

    @Override
    public List<WordRelation> findAllRelations() {
        return wordRelationRepository.findAll();
    }

    @Override
    public List<WordRelation> findByRelation(String relation) {
        return wordRelationRepository.findByRelationEqualsIgnoreCase(relation);
    }
}
