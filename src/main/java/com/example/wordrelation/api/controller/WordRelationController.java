package com.example.wordrelation.api.controller;

import com.example.wordrelation.model.WordRelation;
import com.example.wordrelation.model.WordRelationInverseResponseDto;
import com.example.wordrelation.model.WordRelationRequestDto;
import com.example.wordrelation.model.enums.Relation;
import com.example.wordrelation.service.WordRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/word-relations")
@RequiredArgsConstructor
@Api(value = "Word-Relations API Documentation")
public class WordRelationController {

    private final WordRelationService wordRelationService;

    private final ModelMapper modelMapper;

    @ApiOperation(value = "Add new relation")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRelation(@RequestBody @Valid WordRelationRequestDto dto) {
        WordRelation relation = modelMapper.map(dto, WordRelation.class);
        relation.setRelation(Relation.from(dto.getRelation()));
        wordRelationService.addNewWordRelation(relation);
    }

    @ApiOperation(value = "List All Relations")
    @GetMapping("/{includeInverse}")
    public ResponseEntity<List<WordRelationInverseResponseDto>> listAllRelations(
            @PathVariable(name = "includeInverse", required = false) boolean includeInverse) {
        List<WordRelationInverseResponseDto> list = wordRelationService.findAllRelations(includeInverse);
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "List Relations by relation keyword")
    @GetMapping()
    public ResponseEntity<List<WordRelation>> listRelations(
            @RequestParam("relation") String relation) {
        List<WordRelation> list = wordRelationService.findByRelation(relation);
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "Get a string of relations between related words")
    @GetMapping("relationStr")
    public ResponseEntity<String> relation(@RequestParam("firstWord") String firstWord,
                                           @RequestParam("secondWord") String secondWord) {
        return ResponseEntity.ok(wordRelationService.createRelationStr(firstWord, secondWord));
    }
}
