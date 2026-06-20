package com.example.eth.demo.domain.model;

public record Signature(String hexValue) {
    public Signature {
        if (hexValue == null || hexValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Signature cannot be empty");
        }
    }
}
