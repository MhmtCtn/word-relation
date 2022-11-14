package com.example.wordrelation.api.controller;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.WordRelationInverseResponseDto;
import com.example.wordrelation.model.WordRelationRequestDto;
import com.example.wordrelation.service.WordRelationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/word-relations")
@RequiredArgsConstructor
public class WordRelationController {

    private WordRelationService wordRelationService;

    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRelation(@RequestBody @Valid WordRelationRequestDto dto) {
        WordRelation relation = modelMapper.map(dto, WordRelation.class);
        wordRelationService.addNewWordRelation(relation);
    }

    @GetMapping("/{includeInverse}")
    public ResponseEntity<List<WordRelationInverseResponseDto>> listAllRelations(
            @PathVariable(name = "includeInverse", required = false) boolean includeInverse) {
        List<WordRelationInverseResponseDto> list = wordRelationService.findAllRelations(includeInverse);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{relation}")
    public ResponseEntity<List<WordRelation>> listRelations(
            @PathVariable("relation") String relation) {
        List<WordRelation> list = wordRelationService.findByRelation(relation);
        return ResponseEntity.ok(list);
    }

    @GetMapping("relationStr/{firstWord}/{secondWord}") // Is not well designed
    public ResponseEntity<String> relation(@PathVariable("firstWord") String firstWord,
                                           @PathVariable("secondWord") String secondWord) {
        return ResponseEntity.ok(wordRelationService.createRelationStr(firstWord, secondWord));
    }
}
