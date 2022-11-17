package com.example.wordrelation.model.enums;

public enum Relation {
    SYNONYM, ANTONYM, RELATED;

    public static Relation from(String value) {
        return value != null ? Relation.valueOf(value.toUpperCase()) : null;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
