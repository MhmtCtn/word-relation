package com.example.wordrelation.model.converter;

import com.example.wordrelation.model.enums.Relation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverter implements Converter<String, Relation> {

    @Override
    public Relation convert(String source) {
        try {
            return Relation.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
