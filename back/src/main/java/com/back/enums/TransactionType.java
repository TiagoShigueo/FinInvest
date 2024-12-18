package com.back.enums;

public enum TransactionType {
    ENTRADA("entrada"),
    SAIDA("saida"),
    TRANSFERENCIA("transferencia");

    private String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
