package com.example.wordrelation.model.enums;

public enum Relation {
    SYNONYM("synonym"), ANTONYM("antonym"), RELATED("related");

    private String value;

    Relation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
