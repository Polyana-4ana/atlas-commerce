package com.example.atlascommerce.shared.exception;

public record ValidationError(
        String field,
        String message
) {}
