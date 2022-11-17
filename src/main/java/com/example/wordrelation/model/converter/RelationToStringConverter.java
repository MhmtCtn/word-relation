package com.example.wordrelation.model.converter;

import com.example.wordrelation.model.enums.Relation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RelationToStringConverter implements AttributeConverter<Relation, String> {

    @Override
    public String convertToDatabaseColumn(Relation attribute) {
        return attribute.toString();
    }

    @Override
    public Relation convertToEntityAttribute(String dbData) {
        return Relation.from(dbData);
    }
}
