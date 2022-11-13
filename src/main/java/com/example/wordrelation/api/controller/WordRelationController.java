package com.example.wordrelation.api.controller;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.WordRelationRequestDto;
import com.example.wordrelation.service.WordRelationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/word-relations")
@RequiredArgsConstructor
public class WordRelationController {

    private WordRelationService wordRelationService;

    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRelation(@RequestBody WordRelationRequestDto dto) {
        WordRelation relation = modelMapper.map(dto, WordRelation.class);
        wordRelationService.addNewWordRelation(relation);
    }

    @GetMapping
    public ResponseEntity<List<WordRelation>> listAllRelations() {
        List<WordRelation> list = wordRelationService.findAllRelations();
        return ResponseEntity.ok(list);
    }
}
