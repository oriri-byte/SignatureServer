package com.example.eth.demo.domain.model;

public record DomainName(String value) {
    public DomainName {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Domain name cannot be empty");
        }
        if (!value.matches("^[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Domain name contains invalid characters");
        }
    }
}
