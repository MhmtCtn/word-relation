package com.example.wordrelation.service.impl;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.WordRelationInverseResponseDto;
import com.example.wordrelation.model.enums.YesNo;
import com.example.wordrelation.repository.WordRelationRepository;
import com.example.wordrelation.service.WordRelationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WordRelationServiceImpl implements WordRelationService {

    private WordRelationRepository wordRelationRepository;

    private ModelMapper modelMapper;

    @Override
    public WordRelation addNewWordRelation(WordRelation relation) {
        // Assume null check is done by validation
        relation.setFirstWord(relation.getFirstWord().toLowerCase().trim());
        relation.setSecondWord(relation.getSecondWord().toLowerCase().trim());
        return wordRelationRepository.save(relation);
    }

    @Override
    public List<WordRelationInverseResponseDto> findAllRelations(boolean includeInverse) {
        // TODO needs refactoring!
        List<WordRelation> list = wordRelationRepository.findAll();
        List<WordRelationInverseResponseDto> responseList = list.stream()
                .map(p -> modelMapper.map(p, WordRelationInverseResponseDto.class)).collect(Collectors.toList());

        responseList = responseList.stream().map(s -> {
            WordRelationInverseResponseDto dto = WordRelationInverseResponseDto.builder()
                    .id(s.getId()).firstWord(s.getFirstWord()).secondWord(s.getSecondWord())
                    .relation(s.getRelation()).yesOrNo(YesNo.YES.getValue()).build();
            return dto;
        }).collect(Collectors.toList());

        if (includeInverse) {
            List<WordRelationInverseResponseDto> listWithInverseWords = responseList.stream()
                    .map(p -> new WordRelationInverseResponseDto
                            (p.getId(), p.getSecondWord(), p.getFirstWord(), p.getRelation(), YesNo.NO.getValue()))
                    .collect(Collectors.toList());
            responseList.addAll(listWithInverseWords);
        }
        return responseList;
    }

    @Override
    public List<WordRelation> findByRelation(String relation) {
        return wordRelationRepository.findByRelationEqualsIgnoreCase(relation);
    }
}
