package com.example.eth.demo.domain.model;

public record Address(String value) {
    public Address {
        if (value == null || !value.startsWith("0x")) {
            throw new IllegalArgumentException("Address must start with 0x");
        }
        if (value.length() != 42) {
            throw new IllegalArgumentException("Address must be exactly 42 characters long");
        }
        if (!value.matches("^0x[0-9a-fA-F]{40}$")) {
            throw new IllegalArgumentException("Address must consist of valid hexadecimal characters after 0x");
        }
    }
}
