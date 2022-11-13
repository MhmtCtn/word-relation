package com.example.wordrelation.model.enums;

public enum YesNo {
    YES("yes"), NO("no");

    private String value;

    YesNo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
